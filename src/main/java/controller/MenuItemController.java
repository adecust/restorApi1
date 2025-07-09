package controller;

import model.MenuItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import services.MenuItemService;

@RestController
@RequestMapping("/menuitems")
public class MenuItemController {

    @Autowired
    private MenuItemService menuItemService;

    @PostMapping("/add")
    public MenuItem addMenuItem(@RequestParam Long categoryId, @RequestParam String itemName, @RequestParam double price) {
        return menuItemService.addMenuItemToCategory(categoryId, itemName, price);
    }
}
