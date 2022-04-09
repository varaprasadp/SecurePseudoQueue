package com.natwest.EncryptionMS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.natwest.EncryptionMS.entity.Transaction;
import com.natwest.EncryptionMS.service.TransactionService;

@RestController
public class TransactionController {
	
	@Autowired
	private TransactionService transactionService;
	
	@PostMapping
	public ResponseEntity<String> postTransaction(@RequestBody Transaction transaction){
		String result = transactionService.addTransaction(transaction);
		return new ResponseEntity<String>(result, HttpStatus.OK); 
	}
}
