package dto.response;

import lombok.Data;

@Data
public class MenuItemResponse {
    private Integer code;
    private String name;
    private String description;
    private String category;
    private double price;
    private Boolean isAvailable;
    private Integer menuCode;
}
