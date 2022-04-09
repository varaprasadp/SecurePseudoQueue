package com.natwest.DecryptionMS.service;

import java.util.Base64;
import java.util.Base64.Decoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.natwest.DecryptionMS.entity.TransactionEntity;
import com.natwest.DecryptionMS.repository.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionRepository transactionRepository;
	
	@Override
	public String addTransaction(TransactionEntity transaction) {
		// TODO Auto-generated method stub
		return transactionRepository.saveAndFlush(decryptTransaction(transaction)).toString();
	}
	
	private static TransactionEntity decryptTransaction(TransactionEntity transaction) {
		TransactionEntity decryptedTransaction = new TransactionEntity();
		Decoder decoder = Base64.getDecoder();
		byte[] decodedBytes = decoder.decode(transaction.getAccountNumber());
		decryptedTransaction.setAccountNumber(new String(decodedBytes));
		decodedBytes = decoder.decode(transaction.getType());
		decryptedTransaction.setType(new String(decodedBytes));
		decodedBytes = decoder.decode(transaction.getAmount());
		decryptedTransaction.setAmount(new String(decodedBytes));
		decodedBytes = decoder.decode(transaction.getCurrency());
		decryptedTransaction.setCurrency(new String(decodedBytes));
		decodedBytes = decoder.decode(transaction.getAccountFrom());
		decryptedTransaction.setAccountFrom(new String(decodedBytes));
		return decryptedTransaction;
	}

}
