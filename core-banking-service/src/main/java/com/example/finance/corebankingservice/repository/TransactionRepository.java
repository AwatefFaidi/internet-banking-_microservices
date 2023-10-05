package com.example.finance.corebankingservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.finance.corebankingservice.model.TransactionEntity;

public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {}


