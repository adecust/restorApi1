package services;

import dto.request.MenuRequest;
import dto.response.MenuResponse;
import model.Menu;
import model.Restaurant;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.MenuRepository;
import repository.RestaurantRepository;
import java.time.LocalDateTime;

@Service
public class MenuService {

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private ModelMapper modelMapper;

    public MenuResponse getMenu(Integer code) {
        Menu menu = menuRepository.findByCode(code);
        return modelMapper.map(menu, MenuResponse.class);
    }

    public MenuResponse addMenu(MenuRequest request) {
        Menu menu = modelMapper.map(request, Menu.class);
        Restaurant restaurant = restaurantRepository.findByCode(request.getRestaurantCode());
        menu.setRestaurant(restaurant);
        menu.setCreatedAt(LocalDateTime.now().toString());

        menu = menuRepository.save(menu);
        menu.setCode(30000 + menu.getId().intValue());
        menu = menuRepository.save(menu);

        return modelMapper.map(menu, MenuResponse.class);
    }
}
