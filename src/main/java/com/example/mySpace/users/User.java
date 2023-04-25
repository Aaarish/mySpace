package com.example.mySpace.users;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(value = "users")
public class User {
    private String userId;
    private String firstName;
    private String lastName;
    private String email;
    private String favColor;
    private String favCar;
}
