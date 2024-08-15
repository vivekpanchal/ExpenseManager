package com.vivek.ExpenseManager.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ExpenseDTO {
    private Long id;
    private String description;
    private BigDecimal amount;
    private LocalDate date;
    private Long categoryId;
    private Long userId;
}
