package org.payartz.restorapi.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class MenuItemRequest {
    @NotBlank
    private String name;

    private String description;

    @NotBlank
    private String category;

    @NotNull
    private BigDecimal price;

    private Boolean isAvailable = true;

    @NotNull
    private Long menuId;
}
