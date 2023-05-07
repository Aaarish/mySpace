package com.example.mySpace.users;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static com.example.mySpace.users.Role.NORMAL_USER;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDto addUser(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);

        user.setUserId(UUID.randomUUID().toString());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setRole(NORMAL_USER);

        User savedUser = userRepo.save(user);

        return modelMapper.map(savedUser, UserDto.class);
    }

    @Override
    public List<UserDto> getUsers() {
        List<User> users = userRepo.findAllByRole(NORMAL_USER.name());

        return users.stream()
                .map(u -> modelMapper.map(u, UserDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserDto getUser(String email) {
        User user = userRepo.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("No such user exists"));

        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public UserDto updateUser(String userId, UserDto userDto) {
        User user = userRepo.findById(userId).get();

        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));

        User updatedUser = userRepo.save(user);

        return modelMapper.map(updatedUser, UserDto.class);
    }

    @Override
    public String deleteUser(String userId) {
        userRepo.deleteById(userId);

        return "User deleted successfully";
    }
}
