package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.TransactionDao;
import com.app.model.Transaction;

@Service
@Transactional
public class TransactionServiceImpl implements TransactionService {
	@Autowired
	TransactionDao transactionDao;

	public Transaction createTransaction(Transaction transaction) {
		// TODO Auto-generated method stub
		return transactionDao.save(transaction);
	}

	public List<Transaction> getTransactions() {
		// TODO Auto-generated method stub
		return (List<Transaction>) transactionDao.findAll();
	}

	public Transaction findById(long id) {
		// TODO Auto-generated method stub
		return transactionDao.findOne(id);
	}

	public Transaction update(Transaction transaction) {
		// TODO Auto-generated method stub
		return transactionDao.updateTransaction(transaction);
	}

	public void deleteTransactionById(long id) {
		// TODO Auto-generated method stub
		transactionDao.delete(id);
	}
}
