package com.example.mySpace.users;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserConverter {

    public UserDto convertModelToDto(User user){
        UserDto userDto = new UserDto();

        userDto.setUserId(user.getUserId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());
        userDto.setFavColor(user.getFavColor());
        userDto.setFavCar(user.getFavCar());

        return userDto;
    }

    public User convertDtoToModel(UserDto userDto){
        User user = new User();

        user.setUserId(UUID.randomUUID().toString());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setFavColor(userDto.getFavColor());
        user.setFavCar(userDto.getFavCar());

        return user;
    }
}
