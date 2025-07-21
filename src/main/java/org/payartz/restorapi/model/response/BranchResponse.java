package org.payartz.restorapi.model.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BranchResponse {
    private Long id;
    private String name;
    private String address;
    private String phone;
    private Long restaurantId;
    private LocalDateTime createdAt;
}

