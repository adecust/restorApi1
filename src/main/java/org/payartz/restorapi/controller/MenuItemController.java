package org.payartz.restorapi.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.payartz.restorapi.model.request.MenuItemRequest;
import org.payartz.restorapi.model.response.MenuItemResponse;
import org.payartz.restorapi.services.MenuItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/menu-items")
@RequiredArgsConstructor
public class MenuItemController {

    private final MenuItemService menuItemService;

    @PostMapping
    public ResponseEntity<MenuItemResponse> create(@RequestBody @Valid MenuItemRequest request) {
        return ResponseEntity.ok(menuItemService.createMenuItem(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MenuItemResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(menuItemService.getMenuItemById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MenuItemResponse> update(@PathVariable Long id, @RequestBody @Valid MenuItemRequest request) {
        return ResponseEntity.ok(menuItemService.updateMenuItem(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        menuItemService.deleteMenuItem(id);
        return ResponseEntity.noContent().build();
    }
}
