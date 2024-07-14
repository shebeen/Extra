package com.extra.app.service;

import com.extra.app.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public interface ExpenseService{
    Expense createExpense(Expense expense);
    Expense getExpenseById(Long expenseId);
    List<Expense> getAllExpenses();

    List<Expense> findExpenseByExpenseDate(Date frmDt, Date toDt);
    Expense updateExpense(Expense expense);

    void deleteExpense(Long expenseId);
}
