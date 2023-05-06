package com.example.mySpace.auth;

import com.example.mySpace.dto.AuthenticationRequest;
import com.example.mySpace.dto.AuthenticationResponse;
import com.example.mySpace.dto.RegisterRequest;
import com.example.mySpace.dto.RegisterResponse;

public interface AuthService {
    AuthenticationResponse authenticateUser(AuthenticationRequest authenticationRequest);

    RegisterResponse registerUser(RegisterRequest registerRequest);
}
