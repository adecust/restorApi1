package model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer code; // ör. 10001

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String createdAt;
}
