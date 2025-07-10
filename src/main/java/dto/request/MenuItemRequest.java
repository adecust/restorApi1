package dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Data
public class MenuItemRequest {
    @NotBlank
    private String name;

    private String description;

    @NotBlank
    private String category;

    @PositiveOrZero
    private double price;

    private Boolean isAvailable = true;

    @NotNull
    private Integer menuCode;
}
