package com.extra.app.controller;

import com.extra.app.entity.Expense;
import com.extra.app.service.ExpenseService;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
@CrossOrigin(
        origins = {
                "*"////////
        },
        methods = {
                RequestMethod.OPTIONS,
                RequestMethod.GET,
                RequestMethod.PUT,
                RequestMethod.DELETE,
                RequestMethod.POST
        })
@RestController
@AllArgsConstructor
@RequestMapping("api/expenses")
public class ExpenseController {
    private ExpenseService expenseService;

    @PostMapping
    public ResponseEntity<Expense> createExpense(@RequestBody Expense expense){
        Expense savedExpense = expenseService.createExpense(expense);
        return new ResponseEntity<>(savedExpense, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Expense> getExpenseById(@PathVariable("id") Long expenseId){
        System.out.println("GET Called");
        Expense expense = expenseService.getExpenseById(expenseId);
        return new ResponseEntity<>(expense, HttpStatus.OK);
    }

    // Build Get All Expenses REST API
    @GetMapping
    public ResponseEntity<List<Expense>> getAllExpenses(
            @RequestParam  @DateTimeFormat(pattern="ddMMyyyy") Date frmDt,
            @RequestParam @DateTimeFormat(pattern="ddMMyyyy")Date toDt){
        System.out.println(frmDt+"..."+toDt);
        List<Expense> expenses = expenseService.findExpenseByExpenseDate(frmDt,toDt);
        return new ResponseEntity<>(expenses, HttpStatus.OK);
    }

    // Build Update Expense REST API
    @PutMapping("{id}")
    // http://localhost:8080/api/expenses/1
    public ResponseEntity<Expense> updateExpense(@PathVariable("id") Long expenseId,
                                           @RequestBody Expense expense){
        expense.setId(expenseId);
        Expense updatedExpense = expenseService.updateExpense(expense);
        return new ResponseEntity<>(updatedExpense, HttpStatus.OK);
    }

    // Build Delete Expense REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteExpense(@PathVariable("id") Long expenseId){
        expenseService.deleteExpense(expenseId);
        return new ResponseEntity<>("Expense successfully deleted!", HttpStatus.OK);
    }

}
