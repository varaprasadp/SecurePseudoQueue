package com.natwest.EncryptionMS.service;

import java.util.Arrays;
import java.util.Base64;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.natwest.EncryptionMS.entity.TransactionEntity;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Override
	public String addTransaction(TransactionEntity transaction) {
		// TODO Auto-generated method stub
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	    transaction = restTemplate.postForEntity("https://decryption-ms.herokuapp.com/", 
	    		encryptTransaction(transaction), TransactionEntity.class, headers).getBody();
		return transaction.toString();
	}
	
	public TransactionEntity encryptTransaction(TransactionEntity transaction) {
		TransactionEntity encryptedTransaction = new TransactionEntity();
		encryptedTransaction.setAccountNumber(Base64.getEncoder().encodeToString(transaction.getAccountNumber().getBytes()));
		encryptedTransaction.setType(Base64.getEncoder().encodeToString(transaction.getType().getBytes()));
		encryptedTransaction.setAmount(Base64.getEncoder().encodeToString(transaction.getAmount().getBytes()));
		encryptedTransaction.setCurrency(Base64.getEncoder().encodeToString(transaction.getCurrency().getBytes()));
		encryptedTransaction.setAccountFrom(Base64.getEncoder().encodeToString(transaction.getAccountFrom().getBytes()));
		return encryptedTransaction;
	}

}
