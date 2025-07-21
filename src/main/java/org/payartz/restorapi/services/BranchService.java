package org.payartz.restorapi.services;

import org.payartz.restorapi.model.request.BranchRequest;
import org.payartz.restorapi.model.response.BranchResponse;

public interface BranchService {
    BranchResponse createBranch(BranchRequest request);
    BranchResponse getBranchById(Long id);
    BranchResponse updateBranch(Long id, BranchRequest request);
    void deleteBranch(Long id);
}

