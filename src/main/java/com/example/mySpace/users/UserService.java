package com.example.mySpace.users;

import java.util.List;

public interface UserService {
    UserDto addUser(UserDto userDto);

    List<UserDto> getUsers();
}
