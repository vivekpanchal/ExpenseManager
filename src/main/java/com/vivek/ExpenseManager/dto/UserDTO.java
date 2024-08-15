package com.vivek.ExpenseManager.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL) // Exclude null values from JSON
public class UserDTO {
    private Long id;
    private String username;
    private String email;
    private String password;
}
