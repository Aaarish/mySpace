package com.example.mySpace.auth;

import com.example.mySpace.dto.AuthenticationRequest;
import com.example.mySpace.dto.AuthenticationResponse;
import com.example.mySpace.dto.RegisterRequest;
import com.example.mySpace.dto.RegisterResponse;
import com.example.mySpace.users.*;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserService userService;
    private final UserDetailsService userDetailsService;
    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;
    private final ModelMapper modelMapper;

    @Override
    public RegisterResponse registerUser(RegisterRequest registerRequest) {
        registerRequest.getPassword();
        UserDto userDto = userService.addUser(modelMapper.map(registerRequest, UserDto.class));
        User user = modelMapper.map(userDto, User.class);

        String token = null;

        if(user != null){
            token = jwtUtils.generateToken(user);
        }

        return RegisterResponse.builder()
                .message("User is successfully registered!")
                .jwt(token)
                .build();
    }

    @Override
    public AuthenticationResponse authenticateUser(AuthenticationRequest authenticationRequest) {
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(), authenticationRequest.getPassword());

        Authentication authenticatedUser = authenticationManager.authenticate(authenticationToken);

        String token = null;

        if(authenticatedUser != null){
            UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getEmail());
            token = jwtUtils.generateToken(userDetails);
        }

        return AuthenticationResponse.builder()
                .message("User is successfully authenticated!")
                .jwt(token)
                .build();
    }
}
