package com.extra.app.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "expenses")
@NamedQuery(name="Expense.findByExpenseDate" ,
        query="select e from Expense e where e.expenseDate >= ?1 and e.expenseDate <= ?2")
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String expenseTitle;

    @Column
    private String expenseDescription;

    @Column
    private String expenseType;

    @Column
    private long expenseAmount;

    @Column
    private Date expenseDate;

    @Column
    private Integer userId;
}
