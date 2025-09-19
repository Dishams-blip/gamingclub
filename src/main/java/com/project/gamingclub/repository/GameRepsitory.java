package com.project.gamingclub.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.project.gamingclub.entity.Games;

@Repository
public interface GameRepsitory extends MongoRepository<Games, String> {
    Games findByName(String name); // unique name
}
