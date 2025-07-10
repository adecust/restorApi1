package dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Data
public class OrderRequest {
    @NotBlank
    private String orderTime;

    private String status;

    @PositiveOrZero
    private double totalPrice;

    @NotNull
    private Integer customerCode;

    @NotNull
    private Integer restaurantCode;
}
