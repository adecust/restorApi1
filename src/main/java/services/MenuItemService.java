package services;

import dto.request.MenuItemRequest;
import dto.response.MenuItemResponse;
import model.Menu;
import model.MenuItem;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.MenuItemRepository;
import repository.MenuRepository;

@Service
public class MenuItemService {

    @Autowired
    private MenuItemRepository menuItemRepository;

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private ModelMapper modelMapper;

    public MenuItemResponse getMenuItem(Integer code) {
        MenuItem item = menuItemRepository.findByCode(code);
        return modelMapper.map(item, MenuItemResponse.class);
    }

    public MenuItemResponse addMenuItem(MenuItemRequest request) {
        MenuItem item = modelMapper.map(request, MenuItem.class);
        Menu menu = menuRepository.findByCode(request.getMenuCode());
        item.setMenu(menu);

        item = menuItemRepository.save(item);
        item.setCode(40000 + item.getId().intValue());
        item = menuItemRepository.save(item);

        return modelMapper.map(item, MenuItemResponse.class);
    }
}
