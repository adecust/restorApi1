package org.payartz.restorapi.model.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserDTO {
    private Long id;
    private LocalDateTime createdAt;
    private String email;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String userType;
}
