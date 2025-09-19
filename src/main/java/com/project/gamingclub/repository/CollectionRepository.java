package com.project.gamingclub.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.project.gamingclub.entity.Collections;
import java.time.LocalDate;

@Repository
public interface CollectionRepository extends MongoRepository<Collections, String> {
    Collections findByDate(LocalDate date); // unique per day
}
