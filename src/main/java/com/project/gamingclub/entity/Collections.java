package com.project.gamingclub.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;

@Document(collection = "collections")
public class Collections {

    @Id
    private String id;

    private LocalDate date;    // unique per day
    private double amount;     // total recharge amount for that date

    // Getters & Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    // Constructors
    public Collections(LocalDate date, double amount) {
        this.date = date;
        this.amount = amount;
    }
    public Collections() {}
}
