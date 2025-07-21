package org.payartz.restorapi.model.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RestaurantResponse {
    private Long id;
    private String name;
    private String address;
    private String email;
    private String phone;
    private LocalDateTime createdAt;
}
