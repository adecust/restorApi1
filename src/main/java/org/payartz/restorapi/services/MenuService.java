package org.payartz.restorapi.services;

import org.payartz.restorapi.model.request.MenuRequest;
import org.payartz.restorapi.model.response.MenuResponse;

public interface MenuService {
    MenuResponse createMenu(MenuRequest request);
    MenuResponse getMenuById(Long id);
    MenuResponse updateMenu(Long id, MenuRequest request);
    void deleteMenu(Long id);
}

