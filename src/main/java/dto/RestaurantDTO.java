package dto;

import lombok.Data;

@Data
public class RestaurantDTO {
    private Integer code; // ör. 20001
    private String name;
    private String address;
    private String email;
    private String phone;
    private String createdAt;
}
