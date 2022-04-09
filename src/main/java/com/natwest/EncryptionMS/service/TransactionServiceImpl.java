package com.natwest.EncryptionMS.service;

import org.springframework.stereotype.Service;

import com.natwest.EncryptionMS.entity.Transaction;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Override
	public String addTransaction(Transaction transaction) {
		// TODO Auto-generated method stub
		return transaction.toString();
	}

}
