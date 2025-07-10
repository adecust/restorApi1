package services;

import dto.request.RestaurantRequest;
import dto.response.RestaurantResponse;
import model.Restaurant;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.RestaurantRepository;
import java.time.LocalDateTime;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private ModelMapper modelMapper;

    public RestaurantResponse getRestaurant(Integer code) {
        Restaurant restaurant = restaurantRepository.findByCode(code);
        return modelMapper.map(restaurant, RestaurantResponse.class);
    }

    public RestaurantResponse addRestaurant(RestaurantRequest request) {
        Restaurant restaurant = modelMapper.map(request, Restaurant.class);
        restaurant.setCreatedAt(LocalDateTime.now().toString());

        restaurant = restaurantRepository.save(restaurant);
        restaurant.setCode(20000 + restaurant.getId().intValue());
        restaurant = restaurantRepository.save(restaurant);

        return modelMapper.map(restaurant, RestaurantResponse.class);
    }
}
