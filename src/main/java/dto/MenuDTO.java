package dto;

import lombok.Data;

@Data
public class MenuDTO {
    private Integer code; // ör. 30001
    private String name;
    private String description;
    private String createdAt;
    private Integer restaurantCode; // ilişkili restaurant code
}
