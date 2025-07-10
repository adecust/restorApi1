package dto;

import lombok.Data;

@Data
public class MenuItemDTO {
    private Integer code; // ör. 40001
    private String name;
    private String description;
    private String category;
    private double price;
    private Boolean isAvailable;
    private Integer menuCode; // ilişkili menu code
}
