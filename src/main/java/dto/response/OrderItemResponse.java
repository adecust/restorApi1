package dto.response;

import lombok.Data;

@Data
public class OrderItemResponse {
    private Integer code;
    private double price;
    private int quantity;
    private Integer orderCode;
    private Integer menuItemCode;
}
