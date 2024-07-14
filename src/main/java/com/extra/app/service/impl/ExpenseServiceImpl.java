package com.extra.app.service.impl;

import com.extra.app.entity.Expense;
import com.extra.app.repository.ExpenseRepository;
import com.extra.app.service.ExpenseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ExpenseServiceImpl implements ExpenseService {
    private ExpenseRepository expenseRepository;
    @Override
    public Expense createExpense(Expense expense){
        return expenseRepository.save(expense);
    }
    @Override
    public Expense getExpenseById(Long expenseId){
        Optional<Expense> expense = expenseRepository.findById(expenseId);
        return expense.get();
    }

    @Override
    public List<Expense> getAllExpenses(){
        return expenseRepository.findAll();
    }
    @Override

    public List<Expense> findExpenseByExpenseDate(Date frmDt, Date toDt){
        return expenseRepository.findByExpenseDate(frmDt,toDt);
    }
    @Override
    public Expense updateExpense(Expense expense){
        Expense existingExpense = expenseRepository.findById(expense.getId()).get();
        existingExpense.setExpenseTitle(expense.getExpenseTitle());
        existingExpense.setExpenseDescription(expense.getExpenseDescription());
        existingExpense.setExpenseType(expense.getExpenseType());
        existingExpense.setExpenseAmount(expense.getExpenseAmount());
        existingExpense.setExpenseDate(expense.getExpenseDate());
        return expenseRepository.save(existingExpense);
    }

    @Override
    public void deleteExpense(Long expenseId) {
        expenseRepository.deleteById(expenseId);
    }
}
