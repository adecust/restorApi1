package controller;

import dto.request.MenuItemRequest;
import dto.response.MenuItemResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.MenuItemService;

@RestController
@RequestMapping("/menuitems")
public class MenuItemController {

    @Autowired
    private MenuItemService menuItemService;

    @GetMapping("/{code}")
    public ResponseEntity<MenuItemResponse> getMenuItem(@PathVariable Integer code) {
        MenuItemResponse response = menuItemService.getMenuItem(code);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<MenuItemResponse> addMenuItem(@Valid @RequestBody MenuItemRequest request) {
        MenuItemResponse response = menuItemService.addMenuItem(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
