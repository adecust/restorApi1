package controller;

import model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import services.CategoryService;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/add")
    public Category addCategory(@RequestParam Long restaurantId, @RequestParam String categoryName) {
        return categoryService.addCategoryToRestaurant(restaurantId, categoryName);
    }
}
