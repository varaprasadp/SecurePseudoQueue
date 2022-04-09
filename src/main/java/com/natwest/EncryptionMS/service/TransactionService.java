package com.natwest.EncryptionMS.service;

import com.natwest.EncryptionMS.entity.TransactionEntity;

public interface TransactionService {
	String addTransaction(TransactionEntity transaction);
}
