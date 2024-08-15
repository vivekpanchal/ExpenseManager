package com.vivek.ExpenseManager.controller;


import com.vivek.ExpenseManager.dto.AuthRequest;
import com.vivek.ExpenseManager.dto.AuthResponse;
import com.vivek.ExpenseManager.dto.UserDTO;
import com.vivek.ExpenseManager.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@Tag(name = "Auth", description = "Authentication API")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    @Operation(summary = "Log in", description = "Authenticate user and return JWT token")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest authRequest) {
        AuthResponse authResponse = authService.login(authRequest);
        return ResponseEntity.ok(authResponse);
    }


    @PostMapping("/signup")
    @Operation(summary = "Sign up", description = "Register a new user")
    public ResponseEntity<UserDTO> signUp(@RequestBody UserDTO userDTO) {
        UserDTO registeredUser = authService.registerUser(userDTO);
        return ResponseEntity.ok(registeredUser);
    }

}
