package com.gmail.ramawthar.priyash.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gmail.ramawthar.priyash.model.Transaction;
import com.gmail.ramawthar.priyash.repository.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService {
	
	private TransactionRepository transactionRepository;
	
	
	@Autowired
	public void setTransactionRepository(TransactionRepository transactionRepository) {
		this.transactionRepository = transactionRepository;
	}

	@Override
	public Transaction save(Transaction transaction) {
		return transactionRepository.save(transaction);
	}

	@Override
	public void delete(Transaction transaction) {
		transactionRepository.delete(transaction);

	}

	@Override
	public List<Transaction> findByTranDate(String tranDate) {
		// TODO Auto-generated method stub
		return transactionRepository.findByTranDate(tranDate);
	}

}
