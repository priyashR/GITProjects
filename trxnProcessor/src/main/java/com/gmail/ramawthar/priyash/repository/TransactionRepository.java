package com.gmail.ramawthar.priyash.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.gmail.ramawthar.priyash.model.Transaction;

public interface TransactionRepository extends ElasticsearchRepository<Transaction, String> {

    List<Transaction> findByTranDate(String tranDate);
}
