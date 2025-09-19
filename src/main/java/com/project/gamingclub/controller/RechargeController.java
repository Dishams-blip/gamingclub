package com.project.gamingclub.controller;

import com.project.gamingclub.entity.Recharge;
import com.project.gamingclub.service.RechargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/recharges")
public class RechargeController {

    @Autowired
    private RechargeService rechargeService;

    @PostMapping("/{memberId}")
    public Recharge recharge(@PathVariable String memberId, @RequestParam double amount) {
        return rechargeService.doRecharge(memberId, amount);
    }

    @GetMapping
    public List<Recharge> getAll() {
        return rechargeService.findAll();
    }
}

