package com.natwest.DecryptionMS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.natwest.DecryptionMS.entity.TransactionEntity;
import com.natwest.DecryptionMS.service.TransactionService;

@RestController
public class TransactionController {
	
	@Autowired
	private TransactionService transactionService;
	
	@PostMapping
	public ResponseEntity<String> postTransaction(@RequestBody TransactionEntity transactionEntity){
		String result = transactionService.addTransaction(transactionEntity);
		return new ResponseEntity<String>(result,HttpStatus.CREATED);
	}
}
