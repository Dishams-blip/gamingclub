package com.project.gamingclub.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.project.gamingclub.entity.members;

@Repository
public interface MemberRepository extends MongoRepository<members, String> {
	members findByPhone(String phone); 
}
