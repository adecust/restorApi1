package org.payartz.restorapi.repository;

import org.payartz.restorapi.model.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu, Long> {
}

