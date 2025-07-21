package org.payartz.restorapi.model.converter;

import org.payartz.restorapi.model.entity.Restaurant;
import org.payartz.restorapi.model.request.RestaurantRequest;
import org.payartz.restorapi.model.response.RestaurantResponse;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
@Component
public class RestaurantConverter {

    public Restaurant dtoToEntity(RestaurantRequest request) {
        Restaurant restaurant = new Restaurant();
        restaurant.setName(request.getName());
        restaurant.setAddress(request.getAddress());
        restaurant.setEmail(request.getEmail());
        restaurant.setPhone(request.getPhone());
        restaurant.setCreatedAt(LocalDateTime.now());
        return restaurant;
    }

    public RestaurantResponse entityToResponse(Restaurant restaurant) {
        RestaurantResponse response = new RestaurantResponse();
        response.setId(restaurant.getId());
        response.setName(restaurant.getName());
        response.setAddress(restaurant.getAddress());
        response.setEmail(restaurant.getEmail());
        response.setPhone(restaurant.getPhone());
        response.setCreatedAt(restaurant.getCreatedAt());
        return response;
    }
}

