package org.payartz.restorapi.model.dto;

import lombok.Data;
import org.payartz.restorapi.model.enums.OrderStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class OrderDTO {
    private Long id;
    private LocalDateTime orderTime;
    private OrderStatus status;
    private BigDecimal totalPrice;
    private Long userId;
    private Long branchId;
}
