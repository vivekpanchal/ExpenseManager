package com.vivek.ExpenseManager.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AuthResponse {
    private String token;
}