package dto.response;

import lombok.Data;

@Data
public class MenuResponse {
    private Integer code;
    private String name;
    private String description;
    private String createdAt;
    private Integer restaurantCode;
}
