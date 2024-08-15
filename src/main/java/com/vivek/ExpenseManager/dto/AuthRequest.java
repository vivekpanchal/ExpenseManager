package com.vivek.ExpenseManager.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class AuthRequest {
    private String username;
    private String password;
}