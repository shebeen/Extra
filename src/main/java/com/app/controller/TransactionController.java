package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.app.model.Transaction;
import com.app.service.TransactionService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = { "/transaction" })
public class TransactionController {
	@Autowired
	TransactionService transactionService;

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Transaction> getUserById(@PathVariable("id") long id) {
		System.out.println("Fetching User with id " + id);
		Transaction transaction = transactionService.findById(id);
		if (transaction == null) {
			return new ResponseEntity<Transaction>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Transaction>(transaction, HttpStatus.OK);
	}

	@PostMapping(value = "/create", headers = "Accept=application/json")
	public ResponseEntity<Transaction> createTransaction(@RequestBody Transaction transaction,
			UriComponentsBuilder ucBuilder) {
		System.out.println("Creating User " + transaction.getDate());
		transaction = transactionService.createTransaction(transaction);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/transaction/{id}").buildAndExpand(transaction.getId()).toUri());
		return new ResponseEntity<Transaction>(transaction,headers, HttpStatus.CREATED);
	}

	@GetMapping(value = "/all", headers = "Accept=application/json")
	public List<Transaction> getAllUser() {
		List<Transaction> tasks = transactionService.getTransactions();
		return tasks;
	}
	
	@PutMapping(value="/update", headers="Accept=application/json")
	public ResponseEntity<String> updateUser(@RequestBody Transaction transaction)
	{
		System.out.println("Update");
	if (transactionService.findById(transaction.getId())==null) {
		return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
	}
	transactionService.update(transaction);
	return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@DeleteMapping(value="/{id}", headers ="Accept=application/json")
	public ResponseEntity<Transaction> deleteUser(@PathVariable("id") long id){
		System.out.println("Delete hit!");
		Transaction transaction = transactionService.findById(id);
		if (transaction == null) {
			return new ResponseEntity<Transaction>(HttpStatus.NOT_FOUND);
		}
		transactionService.deleteTransactionById(id);
		return new ResponseEntity<Transaction>(HttpStatus.OK);
	}

}
