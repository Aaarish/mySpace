package com.example.mySpace.auth;

import com.example.mySpace.dto.AuthenticationRequest;
import com.example.mySpace.dto.AuthenticationResponse;
import com.example.mySpace.dto.RegisterRequest;
import com.example.mySpace.dto.RegisterResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@CrossOrigin
public class AuthController {
    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<RegisterResponse> signup(@RequestBody RegisterRequest registerRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(authService.registerUser(registerRequest));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest authenticationRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(authService.authenticateUser(authenticationRequest));
    }
}
