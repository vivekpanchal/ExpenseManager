package com.vivek.ExpenseManager.service;


import com.vivek.ExpenseManager.dto.ExpenseDTO;
import com.vivek.ExpenseManager.entity.Expense;
import com.vivek.ExpenseManager.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    public List<ExpenseDTO> getAllExpenses() {
        return expenseRepository.findAll().stream()
                .map(expense -> new ExpenseDTO(
                        expense.getId(),
                        expense.getDescription(),
                        expense.getAmount(),
                        expense.getDate(),
                        expense.getCategory().getId(),
                        expense.getUser().getId()))
                .collect(Collectors.toList());
    }

    public ExpenseDTO addExpense(ExpenseDTO expenseDTO) {
        Expense expense = new Expense();
        expense.setDescription(expenseDTO.getDescription());
        expense.setAmount(expenseDTO.getAmount());
        expense.setDate(expenseDTO.getDate());
        // Set category and user using service methods
        expenseRepository.save(expense);
        return expenseDTO;
    }
}
