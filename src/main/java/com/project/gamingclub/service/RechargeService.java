package com.project.gamingclub.service;

import com.project.gamingclub.entity.members;
import com.project.gamingclub.entity.Recharge;
import com.project.gamingclub.entity.Collections;
import com.project.gamingclub.repository.MemberRepository;
import com.project.gamingclub.repository.RechargeRepository;
import com.project.gamingclub.repository.CollectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class RechargeService {

    @Autowired
    private RechargeRepository rechargeRepo;

    @Autowired
    private MemberRepository memberRepo;

    @Autowired
    private CollectionRepository collectionRepo;

    public Recharge doRecharge(String memberId, double amount) {
        if (amount < 100) {
            throw new RuntimeException("Minimum recharge is 100!");
        }

        members member = memberRepo.findById(memberId)
                .orElseThrow(() -> new RuntimeException("Member not found"));

        // ✅ Rule: max 5 recharges/day
        LocalDate today = LocalDate.now();
        LocalDateTime start = today.atStartOfDay();
        LocalDateTime end = today.plusDays(1).atStartOfDay();
        long count = rechargeRepo.findByMemberIdAndDateBetween(memberId, start.toLocalDate(), end.toLocalDate()).size();

        if (count >= 5) {
            throw new RuntimeException("Max 5 recharges per day!");
        }

        Recharge recharge = new Recharge();
        recharge.setMemberId(memberId);
        recharge.setAmount(amount);
        recharge.setDate(LocalDateTime.now());
        rechargeRepo.save(recharge);

        // update member balance
        member.setBalance(member.getBalance() + amount);
        memberRepo.save(member);

        // update daily collection
        Collections collection = collectionRepo.findByDate(today);
        if (collection == null) {
            collection = new Collections(today, amount);
        } else {
            collection.setAmount(collection.getAmount() + amount);
        }
        collectionRepo.save(collection);

        return recharge;
    }

    public List<Recharge> findAll() {
        return rechargeRepo.findAll();
    }
}
