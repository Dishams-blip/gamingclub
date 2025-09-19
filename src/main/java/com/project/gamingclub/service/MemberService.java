package com.project.gamingclub.service;

import com.project.gamingclub.entity.members;
import com.project.gamingclub.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepo;

    public members create(members member) {
        if (memberRepo.findByPhone(member.getPhone()) != null) {
            throw new RuntimeException("Phone number already exists!");
        }
        return memberRepo.save(member);
    }

    public List<members> findAll() {
        return memberRepo.findAll();
    }

    public members findById(String id) {
        return memberRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Member not found"));
    }

    public members update(String id,members updated) {
    	members member = findById(id);
        member.setName(updated.getName());
        member.setPhone(updated.getPhone());
        member.setBalance(updated.getBalance());
        return memberRepo.save(member);
    }

    public void delete(String id) {
        memberRepo.deleteById(id);
    }
}
