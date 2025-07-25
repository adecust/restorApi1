package org.payartz.restorapi.services.Impl;

import lombok.RequiredArgsConstructor;
import org.payartz.restorapi.exception.ErrorCode;
import org.payartz.restorapi.exception.exceptions.ResourceNotFoundException;
import org.payartz.restorapi.model.converter.BranchConverter;
import org.payartz.restorapi.model.entity.Branch;
import org.payartz.restorapi.model.entity.Restaurant;
import org.payartz.restorapi.model.request.BranchRequest;
import org.payartz.restorapi.model.response.BranchResponse;
import org.payartz.restorapi.repository.BranchRepository;
import org.payartz.restorapi.services.BranchService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Transactional
public class BranchServiceImpl implements BranchService {

    private final BranchRepository branchRepository;
    private final BranchConverter branchConverter;

    @Override
    public BranchResponse createBranch(BranchRequest request) {
        Branch branch = new Branch();
        branch.setName(request.getName());
        branch.setAddress(request.getAddress());
        branch.setPhone(request.getPhone());

        Restaurant restaurant = new Restaurant();
        restaurant.setId(request.getRestaurantId());
        branch.setRestaurant(restaurant);

        branch.setCreatedAt(LocalDateTime.now());

        Branch saved = branchRepository.save(branch);
        return branchConverter.entityToResponse(saved);
    }

    @Override
    @Transactional(readOnly = true)
    public BranchResponse getBranchById(Long id) {
        Branch branch = branchRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ErrorCode.BRANCH_NOT_FOUND, "Branch bulunamadı: " + id));
        return branchConverter.entityToResponse(branch);
    }

    @Override
    public BranchResponse updateBranch(Long id, BranchRequest request) {
        Branch branch = branchRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ErrorCode.BRANCH_NOT_FOUND, "Branch bulunamadı: " + id));
        branch.setName(request.getName());
        branch.setAddress(request.getAddress());
        branch.setPhone(request.getPhone());
        Restaurant restaurant = new Restaurant();
        restaurant.setId(request.getRestaurantId());
        branch.setRestaurant(restaurant);
        Branch updated = branchRepository.save(branch);
        return branchConverter.entityToResponse(updated);
    }

    @Override
    public void deleteBranch(Long id) {
        if (!branchRepository.existsById(id)) {
            throw new ResourceNotFoundException(ErrorCode.BRANCH_NOT_FOUND, "Branch bulunamadı: " + id);
        }
        branchRepository.deleteById(id);
    }
}
