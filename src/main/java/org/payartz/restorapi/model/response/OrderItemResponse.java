package org.payartz.restorapi.model.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderItemResponse {
    private Long id;
    private Integer quantity;
    private BigDecimal price;
    private Long orderId;
    private Long menuItemId;
}

