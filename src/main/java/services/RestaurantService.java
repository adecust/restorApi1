package services;

import lombok.Getter;
import lombok.Setter;
import model.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.RestaurantRepository;

import java.util.List;
import java.util.Optional;

@Getter
@Setter
@Service
public class RestaurantService {
    @Autowired
    private RestaurantRepository restaurantRepository;

    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    public Restaurant addRestaurant(Restaurant Restaurant) {
        return restaurantRepository.save(Restaurant);
    }

    public Optional<Restaurant> getRestaurantById(Long id) {
        return restaurantRepository.findById(id);
    }

    public Restaurant updateRestaurant(Long id, Restaurant updatedRestaurant) {
        Optional<Restaurant> optionalRestaurant = restaurantRepository.findById(id);
        if (optionalRestaurant.isPresent()) {
            Restaurant restaurant = optionalRestaurant.get();
            restaurant.setRestaurantName(updatedRestaurant.getRestaurantName());
            restaurant.setRestaurantLocation(updatedRestaurant.getRestaurantLocation());
            return restaurantRepository.save(restaurant);
        } else {
            updatedRestaurant.setId(id);
            return restaurantRepository.save(updatedRestaurant);
        }
    }

    public void deleteRestaurant(Long id) {
        restaurantRepository.deleteById(id);
    }

}

