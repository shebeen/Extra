package com.extra.app.repository;

import com.extra.app.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Long>{
    List<Expense> findByExpenseDate(Date frmDt, Date toDt);
}
