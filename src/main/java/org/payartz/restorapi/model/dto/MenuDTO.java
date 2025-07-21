package org.payartz.restorapi.model.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MenuDTO {
    private Long id;
    private String name;
    private String description;
    private LocalDateTime createdAt;
    private Long branchId;
}
