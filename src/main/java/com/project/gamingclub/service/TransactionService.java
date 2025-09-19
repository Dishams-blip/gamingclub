package com.project.gamingclub.service;

import com.project.gamingclub.entity.Transactions;
import com.project.gamingclub.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository txnRepo;

    public Transactions create(Transactions txn) {
        return txnRepo.save(txn);
    }

    public List<Transactions> findAll() {
        return txnRepo.findAll();
    }
}
