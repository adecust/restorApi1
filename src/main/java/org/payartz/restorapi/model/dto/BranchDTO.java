package org.payartz.restorapi.model.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BranchDTO {
    private Long id;
    private String name;
    private String address;
    private String phone;
    private LocalDateTime createdAt;
    private Long restaurantId;
}

