package com.project.gamingclub.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Document(collection = "recharges")
public class Recharge {

    @Id
    private String id;

    
    private String memberId;  

    private double amount;

    private LocalDateTime date = LocalDateTime.now();

    // --- Getters & Setters ---
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getMemberId() {
        return memberId;
    }
    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDateTime getDate() {
        return date;
    }
    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    // --- Constructor ---
    public Recharge(String memberId, double amount) {
        this.memberId = memberId;
        this.amount = amount;
    }

    public Recharge() {}
}
