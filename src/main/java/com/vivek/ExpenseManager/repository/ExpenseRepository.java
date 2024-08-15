package com.vivek.ExpenseManager.repository;

import com.vivek.ExpenseManager.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

}
