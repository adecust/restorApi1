package dto;

import lombok.Data;

@Data
public class CustomerDTO {
    private Integer code; // ör. 10001
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String createdAt;
}
