package com.example.mySpace.users;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    private String userId;
    private String firstName;
    private String lastName;
    private String email;
    private String favColor;
    private String favCar;
}
