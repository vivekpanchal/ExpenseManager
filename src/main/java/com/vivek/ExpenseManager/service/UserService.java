package com.vivek.ExpenseManager.service;


import com.vivek.ExpenseManager.dto.UserDTO;
import com.vivek.ExpenseManager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(user -> {
                    UserDTO userDTO = new UserDTO();
                    userDTO.setId(user.getId());
                    userDTO.setUsername(user.getUsername());
                    userDTO.setEmail(user.getEmail());
                    // Do not set password here
                    return userDTO;
                })
                .collect(Collectors.toList());
    }



}
