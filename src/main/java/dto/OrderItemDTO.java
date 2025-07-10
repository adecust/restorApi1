package dto;

import lombok.Data;

@Data
public class OrderItemDTO {
    private Integer code; // ör. 60001
    private double price;
    private int quantity;
    private Integer orderCode; // ilişkili order code
    private Integer menuItemCode; // ilişkili menu item code
}
