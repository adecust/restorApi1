package dto;

import lombok.Data;

@Data
public class OrderDTO {
    private Integer code; // ör. 50001
    private String orderTime;
    private String status;
    private double totalPrice;
    private Integer customerCode; // ilişkili müşteri code
    private Integer restaurantCode; // ilişkili restaurant code
}
