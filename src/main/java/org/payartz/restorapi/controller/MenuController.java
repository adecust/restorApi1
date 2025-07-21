package org.payartz.restorapi.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.payartz.restorapi.model.request.MenuRequest;
import org.payartz.restorapi.model.response.MenuResponse;
import org.payartz.restorapi.services.MenuService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/menus")
@RequiredArgsConstructor
public class MenuController {
    private final MenuService menuService;

    @PostMapping
    public MenuResponse createMenu(@RequestBody @Valid MenuRequest request) {
        return menuService.createMenu(request);
    }

    @GetMapping("/{id}")
    public MenuResponse getMenuById(@PathVariable Long id) {
        return menuService.getMenuById(id);
    }

    @PutMapping("/{id}")
    public MenuResponse updateMenu(@PathVariable Long id, @RequestBody @Valid MenuRequest request) {
        return menuService.updateMenu(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteMenu(@PathVariable Long id) {
        menuService.deleteMenu(id);
    }
}
