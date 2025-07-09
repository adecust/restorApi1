package services;

import model.Category;
import model.MenuItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.CategoryRepository;
import repository.MenuItemRepository;

@Service
public class MenuItemService {

    @Autowired
    private MenuItemRepository menuItemRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public MenuItem addMenuItemToCategory(Long categoryId, String itemName, double price) {
        Category category = categoryRepository.findById(categoryId).orElse(null);
        if (category != null) {
            MenuItem item = new MenuItem();
            item.setItemName(itemName);
            item.setPrice(price);
            item.setCategory(category);
            return menuItemRepository.save(item);
        }
        return null;
    }
}
