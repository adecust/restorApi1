package org.payartz.restorapi.repository;

import org.payartz.restorapi.model.entity.Branch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BranchRepository extends JpaRepository<Branch, Long> {
}

