package org.payartz.restorapi.model.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class MenuItemDTO {
    private Long id;
    private String name;
    private String description;
    private String category;
    private BigDecimal price;
    private Boolean isAvailable;
    private Long menuId;
}
