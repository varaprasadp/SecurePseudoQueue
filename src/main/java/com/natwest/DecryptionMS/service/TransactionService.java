package com.natwest.DecryptionMS.service;

import com.natwest.DecryptionMS.entity.TransactionEntity;

public interface TransactionService {
	String addTransaction(TransactionEntity transaction);
}
