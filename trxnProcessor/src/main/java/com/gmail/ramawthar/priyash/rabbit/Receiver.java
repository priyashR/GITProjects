package com.gmail.ramawthar.priyash.rabbit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gmail.ramawthar.priyash.queueLogic.ProcessTransactions;
import com.gmail.ramawthar.priyash.service.TransactionService;

@Component
public class Receiver {

    @Autowired
    TransactionService transactionService;
    
    public void receiveMessage(Object message) {
        System.out.println("Received <" + message.toString() + ">");
        
        ProcessTransactions pt = new ProcessTransactions(message.toString(), transactionService);
        pt.action();
    }

}
