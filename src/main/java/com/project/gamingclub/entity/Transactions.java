package com.project.gamingclub.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Document(collection = "transactions")
public class Transactions {

    @Id
    private String id;

    private String memberId;   
    private String gameId;   
    private LocalDateTime date = LocalDateTime.now();

    // Getters & Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getMemberId() { return memberId; }
    public void setMemberId(String memberId) { this.memberId = memberId; }

    public String getGameId() { return gameId; }
    public void setGameId(String gameId) { this.gameId = gameId; }

    public LocalDateTime getDate() { return date; }
    public void setDate(LocalDateTime date) { this.date = date; }

    // Constructors
    public Transactions(String memberId, String gameId) {
        this.memberId = memberId;
        this.gameId = gameId;
    }
    public Transactions() {}
}
