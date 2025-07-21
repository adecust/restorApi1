package org.payartz.restorapi.services;

import org.payartz.restorapi.model.request.RestaurantRequest;
import org.payartz.restorapi.model.response.RestaurantResponse;

public interface RestaurantService {
    RestaurantResponse createRestaurant(RestaurantRequest request);
    RestaurantResponse getRestaurantById(Long id);
    RestaurantResponse updateRestaurant(Long id, RestaurantRequest request);
    void deleteRestaurant(Long id);
}
