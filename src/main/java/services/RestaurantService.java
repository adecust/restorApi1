package services;

import dto.RestaurantDTO;
import model.Restaurant;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.RestaurantRepository;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private ModelMapper modelMapper;

    public RestaurantDTO getRestaurant(Integer code) {
        Restaurant restaurant = restaurantRepository.findByCode(code);
        return modelMapper.map(restaurant, RestaurantDTO.class);
    }

    public RestaurantDTO addRestaurant(RestaurantDTO dto) {
        Restaurant restaurant = modelMapper.map(dto, Restaurant.class);
        restaurant = restaurantRepository.save(restaurant);
        restaurant.setCode(20000 + restaurant.getId().intValue());
        restaurant = restaurantRepository.save(restaurant);
        return modelMapper.map(restaurant, RestaurantDTO.class);
    }
}
