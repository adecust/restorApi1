package services;

import dto.MenuDTO;
import model.Menu;
import model.Restaurant;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.MenuRepository;
import repository.RestaurantRepository;

@Service
public class MenuService {

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private ModelMapper modelMapper;

    public MenuDTO getMenu(Integer code) {
        Menu menu = menuRepository.findByCode(code);
        return modelMapper.map(menu, MenuDTO.class);
    }

    public MenuDTO addMenu(MenuDTO dto) {
        Menu menu = modelMapper.map(dto, Menu.class);
        Restaurant restaurant = restaurantRepository.findByCode(dto.getRestaurantCode());
        menu.setRestaurant(restaurant);

        menu = menuRepository.save(menu);
        menu.setCode(30000 + menu.getId().intValue());
        menu = menuRepository.save(menu);

        return modelMapper.map(menu, MenuDTO.class);
    }
}
