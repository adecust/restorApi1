package controller;

import dto.MenuItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import services.MenuItemService;

@RestController
@RequestMapping("/menuitems")
public class MenuItemController {

    @Autowired
    private MenuItemService menuItemService;

    @GetMapping("/{code}")
    public MenuItemDTO getMenuItem(@PathVariable Integer code) {
        return menuItemService.getMenuItem(code);
    }

    @PostMapping
    public MenuItemDTO addMenuItem(@RequestBody MenuItemDTO dto) {
        return menuItemService.addMenuItem(dto);
    }
}
