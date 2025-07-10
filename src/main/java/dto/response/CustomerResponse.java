package dto.response;

import lombok.Data;

@Data
public class CustomerResponse {
    private Integer code;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String createdAt;
}
