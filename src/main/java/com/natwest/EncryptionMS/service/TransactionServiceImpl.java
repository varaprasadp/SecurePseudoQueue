package com.natwest.EncryptionMS.service;

import org.springframework.stereotype.Service;

import com.natwest.EncryptionMS.entity.TransactionEntity;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Override
	public String addTransaction(TransactionEntity transaction) {
		// TODO Auto-generated method stub
		return transaction.toString();
	}

}
