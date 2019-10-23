package com.app.service;

import java.util.List;

import com.app.model.Transaction;

public interface TransactionService {
	public Transaction createTransaction(Transaction transaction);
	public List<Transaction> getTransactions();
	public Transaction findById(long id);
	public Transaction update(Transaction transaction);
	public void deleteTransactionById(long id);
}
