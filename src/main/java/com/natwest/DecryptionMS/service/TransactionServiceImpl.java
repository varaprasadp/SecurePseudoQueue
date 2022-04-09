package com.natwest.DecryptionMS.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.natwest.DecryptionMS.entity.TransactionEntity;
import com.natwest.DecryptionMS.repository.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	TransactionRepository transactionRepository;
	
	@Override
	public String addTransaction(TransactionEntity transaction) {
		// TODO Auto-generated method stub
		return transactionRepository.saveAndFlush(transaction).toString();
	}

}
