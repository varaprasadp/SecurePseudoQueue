package com.natwest.DecryptionMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.natwest.DecryptionMS.entity.TransactionEntity;

public interface TransactionRepository extends JpaRepository<TransactionEntity, String> {

}
