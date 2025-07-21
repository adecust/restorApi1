package org.payartz.restorapi.model.converter;

import jakarta.persistence.EntityNotFoundException;
import org.payartz.restorapi.model.entity.Branch;
import org.payartz.restorapi.model.entity.Restaurant;
import org.payartz.restorapi.model.request.BranchRequest;
import org.payartz.restorapi.model.response.BranchResponse;
import org.payartz.restorapi.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class BranchConverter {

    private final RestaurantRepository restaurantRepository;

    @Autowired
    public BranchConverter(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public Branch dtoToEntity(BranchRequest request) {
        Branch branch = new Branch();
        branch.setName(request.getName());
        branch.setAddress(request.getAddress());
        branch.setPhone(request.getPhone());

        Restaurant restaurant = restaurantRepository.findById(request.getRestaurantId())
                .orElseThrow(() -> new EntityNotFoundException("Restaurant bulunamadı: " + request.getRestaurantId()));

        branch.setRestaurant(restaurant);  // burada restaurant entity set ediliyor
        branch.setCreatedAt(LocalDateTime.now());
        return branch;
    }

    public BranchResponse entityToResponse(Branch branch) {
        BranchResponse response = new BranchResponse();
        response.setId(branch.getId());
        response.setName(branch.getName());
        response.setAddress(branch.getAddress());
        response.setPhone(branch.getPhone());
        response.setRestaurantId(branch.getRestaurant().getId());  // ID olarak dönüyoruz
        response.setCreatedAt(branch.getCreatedAt());
        return response;
    }
}


