package com.app.dao;

import java.util.List;

import com.app.model.Transaction;

public interface TransactionDao {
	public Transaction save(Transaction transaction);
	public List<Transaction> findAll();
	public Transaction findOne(long id);
	public Transaction updateTransaction(Transaction transaction);
	public void delete(long id);
}
