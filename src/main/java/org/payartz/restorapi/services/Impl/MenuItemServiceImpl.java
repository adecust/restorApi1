package org.payartz.restorapi.services.Impl;

import lombok.RequiredArgsConstructor;
import org.payartz.restorapi.exception.ErrorCode;
import org.payartz.restorapi.exception.exceptions.ResourceNotFoundException;
import org.payartz.restorapi.model.converter.MenuItemConverter;
import org.payartz.restorapi.model.entity.MenuItem;
import org.payartz.restorapi.model.request.MenuItemRequest;
import org.payartz.restorapi.model.response.MenuItemResponse;
import org.payartz.restorapi.repository.MenuItemRepository;
import org.payartz.restorapi.services.MenuItemService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class MenuItemServiceImpl implements MenuItemService {

    private final MenuItemRepository menuItemRepository;
    private final MenuItemConverter menuItemConverter;

    @Override
    public MenuItemResponse createMenuItem(MenuItemRequest request) {
        MenuItem item = menuItemConverter.dtoToEntity(request);
        MenuItem saved = menuItemRepository.save(item);
        return menuItemConverter.entityToResponse(saved);
    }

    @Override
    @Transactional(readOnly = true)
    public MenuItemResponse getMenuItemById(Long id) {
        MenuItem item = menuItemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ErrorCode.MENU_ITEM_NOT_FOUND, "MenuItem bulunamadı: " + id));
        return menuItemConverter.entityToResponse(item);
    }

    @Override
    public MenuItemResponse updateMenuItem(Long id, MenuItemRequest request) {
        MenuItem existing = menuItemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ErrorCode.MENU_ITEM_NOT_FOUND, "MenuItem bulunamadı: " + id));
        MenuItem updated = menuItemConverter.dtoToEntity(request);
        updated.setId(existing.getId());
        MenuItem saved = menuItemRepository.save(updated);
        return menuItemConverter.entityToResponse(saved);
    }

    @Override
    public void deleteMenuItem(Long id) {
        if (!menuItemRepository.existsById(id)) {
            throw new ResourceNotFoundException(ErrorCode.MENU_ITEM_NOT_FOUND, "MenuItem bulunamadı: " + id);
        }
        menuItemRepository.deleteById(id);
    }
}
