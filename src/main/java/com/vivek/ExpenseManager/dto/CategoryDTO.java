package com.vivek.ExpenseManager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Data
public class CategoryDTO {
    private Long id;
    private String name;
    private Long userId;
}
