package controller;

import dto.request.MenuRequest;
import dto.response.MenuResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.MenuService;

@RestController
@RequestMapping("/menus")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping("/{code}")
    public ResponseEntity<MenuResponse> getMenu(@PathVariable Integer code) {
        MenuResponse response = menuService.getMenu(code);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<MenuResponse> addMenu(@Valid @RequestBody MenuRequest request) {
        MenuResponse response = menuService.addMenu(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
