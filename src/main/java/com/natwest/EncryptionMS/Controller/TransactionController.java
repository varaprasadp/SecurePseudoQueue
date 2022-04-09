package com.natwest.EncryptionMS.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.natwest.EncryptionMS.entity.TransactionEntity;
import com.natwest.EncryptionMS.service.TransactionService;

@RestController
public class TransactionController {
	
	@Autowired
	private TransactionService transactionService;
	
	@PostMapping
	public ResponseEntity<String> postTransaction(@Valid @RequestBody TransactionEntity transaction, BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			return validation(bindingResult);
		}
		String result = transactionService.addTransaction(transaction);
		return new ResponseEntity<String>(result, HttpStatus.OK); 
	}
	
	public ResponseEntity<String> validation(BindingResult bindingResult){
		String errorsList = "";
		List<ObjectError> errors = bindingResult.getAllErrors();
		for(ObjectError error: errors) {
			errorsList += error.getDefaultMessage() + "\n";
		}
		return new ResponseEntity<String>("Invalid data, fields can't be empty or null or field does not satisfy the below condition \n" 
				+ errorsList, HttpStatus.NOT_ACCEPTABLE);
	}
}
