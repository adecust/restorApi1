package org.payartz.restorapi.services.Impl;

import lombok.RequiredArgsConstructor;
import org.payartz.restorapi.exception.ErrorCode;
import org.payartz.restorapi.exception.exceptions.ResourceNotFoundException;
import org.payartz.restorapi.model.converter.RestaurantConverter;
import org.payartz.restorapi.model.entity.Restaurant;
import org.payartz.restorapi.model.request.RestaurantRequest;
import org.payartz.restorapi.model.response.RestaurantResponse;
import org.payartz.restorapi.repository.RestaurantRepository;
import org.payartz.restorapi.services.RestaurantService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository restaurantRepository;
    private final RestaurantConverter restaurantConverter;

    @Override
    public RestaurantResponse createRestaurant(RestaurantRequest request) {
        Restaurant restaurant = restaurantConverter.dtoToEntity(request);
        Restaurant saved = restaurantRepository.save(restaurant);
        return restaurantConverter.entityToResponse(saved);
    }

    @Override
    @Transactional(readOnly = true)
    public RestaurantResponse getRestaurantById(Long id) {
        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ErrorCode.RESTAURANT_NOT_FOUND, "Restaurant bulunamadı: " + id));
        return restaurantConverter.entityToResponse(restaurant);
    }

    @Override
    public RestaurantResponse updateRestaurant(Long id, RestaurantRequest request) {
        Restaurant existing = restaurantRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ErrorCode.RESTAURANT_NOT_FOUND, "Güncellenmek istenen restoran bulunamadı: " + id));
        Restaurant updated = restaurantConverter.dtoToEntity(request);
        updated.setId(existing.getId());
        updated.setCreatedAt(existing.getCreatedAt());
        Restaurant saved = restaurantRepository.save(updated);
        return restaurantConverter.entityToResponse(saved);
    }

    @Override
    public void deleteRestaurant(Long id) {
        if (!restaurantRepository.existsById(id)) {
            throw new ResourceNotFoundException(ErrorCode.RESTAURANT_NOT_FOUND, "Silinmek istenen restoran bulunamadı: " + id);
        }
        restaurantRepository.deleteById(id);
    }
}
