package com.example.mySpace.users;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;
    private final UserConverter userConverter;

    @Override
    public UserDto addUser(UserDto userDto) {
        User user = userConverter.convertDtoToModel(userDto);
        User savedUser = userRepo.save(user);

        return userConverter.convertModelToDto(savedUser);
    }

    @Override
    public List<UserDto> getUsers() {
        List<User> users = userRepo.findAll();

        List<UserDto> userDtos = users.stream()
                .map(u -> userConverter.convertModelToDto(u))
                .collect(Collectors.toList());

        return userDtos;
    }
}
