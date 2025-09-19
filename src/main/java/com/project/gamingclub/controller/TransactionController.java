package com.project.gamingclub.controller;

import com.project.gamingclub.entity.Transactions;
import com.project.gamingclub.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    @Autowired
    private TransactionService txnService;

    @PostMapping
    public Transactions create(@RequestBody Transactions txn) {
        return txnService.create(txn);
    }

    @GetMapping
    public List<Transactions> getAll() {
        return txnService.findAll();
    }
}
