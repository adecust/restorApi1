package controller;

import dto.MenuDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import services.MenuService;

@RestController
@RequestMapping("/menus")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping("/{code}")
    public MenuDTO getMenu(@PathVariable Integer code) {
        return menuService.getMenu(code);
    }

    @PostMapping
    public MenuDTO addMenu(@RequestBody MenuDTO dto) {
        return menuService.addMenu(dto);
    }
}
