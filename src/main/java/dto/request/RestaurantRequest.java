package dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RestaurantRequest {
    @NotBlank
    @Size(min = 2, max = 50)
    private String name;

    @NotBlank
    private String address;

    @Email
    private String email;

    @NotBlank
    private String phone;
}
