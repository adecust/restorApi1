package org.payartz.restorapi.model.converter;

import org.payartz.restorapi.model.dto.MenuItemDTO;
import org.payartz.restorapi.model.entity.Menu;
import org.payartz.restorapi.model.entity.MenuItem;
import org.payartz.restorapi.model.request.MenuItemRequest;
import org.payartz.restorapi.model.response.MenuItemResponse;
import org.springframework.stereotype.Component;
@Component
public class MenuItemConverter {

    public MenuItem dtoToEntity(MenuItemRequest request) {
        MenuItem item = new MenuItem();
        item.setName(request.getName());
        item.setDescription(request.getDescription());
        item.setCategory(request.getCategory());
        item.setPrice(request.getPrice());
        item.setIsAvailable(request.getIsAvailable() != null ? request.getIsAvailable() : true);

        Menu menu = new Menu();
        menu.setId(request.getMenuId());
        item.setMenu(menu);

        return item;
    }

    public MenuItemResponse entityToResponse(MenuItem item) {
        MenuItemResponse response = new MenuItemResponse();
        response.setId(item.getId());
        response.setName(item.getName());
        response.setDescription(item.getDescription());
        response.setCategory(item.getCategory());
        response.setPrice(item.getPrice());
        response.setIsAvailable(item.getIsAvailable());
        response.setMenuId(item.getMenu().getId());
        return response;
    }
}
