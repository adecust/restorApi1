package org.payartz.restorapi.model.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderItemDTO {
    private Long id;
    private Integer quantity;
    private BigDecimal price;
    private Long orderId;
    private Long menuItemId;
}
