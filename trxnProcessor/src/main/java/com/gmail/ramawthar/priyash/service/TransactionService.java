package com.gmail.ramawthar.priyash.service;

import java.util.List;

import com.gmail.ramawthar.priyash.model.Transaction;

public interface TransactionService {
	
	Transaction save (Transaction transaction);

    void delete(Transaction transaction);
    
    List<Transaction> findByTranDate(String tranDate);
}
