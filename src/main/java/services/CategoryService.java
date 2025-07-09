package services;

import model.Category;
import model.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.CategoryRepository;
import repository.RestaurantRepository;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    public Category addCategoryToRestaurant(Long restaurantId, String categoryName) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId).orElse(null);
        if (restaurant != null) {
            Category category = new Category();
            category.setCategoryName(categoryName);
            category.setRestaurant(restaurant);
            return categoryRepository.save(category);
        }
        return null;
    }
}
