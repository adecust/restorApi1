package dto.response;

import lombok.Data;

@Data
public class RestaurantResponse {
    private Integer code;
    private String name;
    private String address;
    private String email;
    private String phone;
    private String createdAt;
}
