package com.app.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.model.Transaction;

@Repository
@Transactional
public class TransactionDaoImpl implements TransactionDao{
	@Autowired
	SessionFactory sessionFactory;
	
	public void save(Transaction transaction) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(transaction);
	}
	
	public List<Transaction> findAll() {
		Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(Transaction.class).list();
	}

	public Transaction findOne(long id) {
		Session session = sessionFactory.getCurrentSession();
		return (Transaction) session.createCriteria(Transaction.class).add(Restrictions.idEq(id)).uniqueResult();
	}

	public Transaction updateTransaction(Transaction transaction) {
		Session session = sessionFactory.getCurrentSession();
		if(session.contains(transaction)) {
			session.merge(transaction);
		}
		else {
			session.update(transaction);
		}
		return transaction;
	}

	public void delete(long id) {
		Session session = sessionFactory.getCurrentSession();
		// First retreive the object using id
		Transaction transaction = findOne(id);
		// Now use the retrieved object to delete.
		session.delete(transaction);
	}

	
}
