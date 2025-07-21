package org.payartz.restorapi.model.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MenuResponse {
    private Long id;
    private String name;
    private String description;
    private Long branchId;
    private LocalDateTime createdAt;
}
