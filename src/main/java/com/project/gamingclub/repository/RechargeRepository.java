package com.project.gamingclub.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.project.gamingclub.entity.Recharge;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface RechargeRepository extends MongoRepository<Recharge, String> {
    List<Recharge> findByMemberIdAndDateBetween(String memberId, LocalDate start, LocalDate end);
}
