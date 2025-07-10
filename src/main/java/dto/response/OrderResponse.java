package dto.response;

import lombok.Data;

@Data
public class OrderResponse {
    private Integer code;
    private String orderTime;
    private String status;
    private double totalPrice;
    private Integer customerCode;
    private Integer restaurantCode;
}
