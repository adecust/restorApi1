package org.payartz.restorapi.model.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RestaurantDTO {
    private Long id;
    private String name;
    private String address;
    private String email;
    private String phone;
    private LocalDateTime createdAt;
}

