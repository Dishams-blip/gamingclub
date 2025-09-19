package com.project.gamingclub.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.project.gamingclub.entity.Transactions;

@Repository
public interface TransactionRepository extends MongoRepository<Transactions, String> {
}
