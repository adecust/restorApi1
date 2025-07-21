package org.payartz.restorapi.model.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderItemRequest {
    @NotNull
    private Integer quantity;

    @NotNull
    private BigDecimal price;

    @NotNull
    private Long orderId;

    @NotNull
    private Long menuItemId;
}
