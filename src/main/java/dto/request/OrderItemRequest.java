package dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Data
public class OrderItemRequest {
    @PositiveOrZero
    private double price;

    @Positive
    private int quantity;

    @NotNull
    private Integer orderCode;

    @NotNull
    private Integer menuItemCode;
}
