package com.vivek.ExpenseManager.service;

import com.vivek.ExpenseManager.dto.AuthRequest;
import com.vivek.ExpenseManager.dto.AuthResponse;
import com.vivek.ExpenseManager.dto.UserDTO;
import com.vivek.ExpenseManager.entity.User;
import com.vivek.ExpenseManager.repository.UserRepository;
import com.vivek.ExpenseManager.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    public AuthResponse login(AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtUtil.generateToken(authRequest.getUsername());
        return new AuthResponse(token);
    }


    public UserDTO registerUser(UserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword())); // Hash the password
        // Save the user and retrieve the saved entity
        User savedUser = userRepository.save(user);
        userDTO.setPassword(null); // Clear password in response
        userDTO.setId(savedUser.getId());
        return userDTO;
    }

}
