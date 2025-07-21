package org.payartz.restorapi.model.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.payartz.restorapi.model.enums.OrderStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class OrderRequest {
    @NotNull
    private LocalDateTime orderTime;

    @NotNull
    private OrderStatus status;

    @NotNull
    private BigDecimal totalPrice;

    @NotNull
    private Long userId;

    @NotNull
    private Long branchId;
}
