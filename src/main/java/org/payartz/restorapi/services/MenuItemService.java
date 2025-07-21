package org.payartz.restorapi.services;

import org.payartz.restorapi.model.request.MenuItemRequest;
import org.payartz.restorapi.model.response.MenuItemResponse;

public interface MenuItemService {
    MenuItemResponse createMenuItem(MenuItemRequest request);
    MenuItemResponse getMenuItemById(Long id);
    MenuItemResponse updateMenuItem(Long id, MenuItemRequest request);
    void deleteMenuItem(Long id);
}

