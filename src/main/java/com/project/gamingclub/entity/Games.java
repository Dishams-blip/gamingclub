package com.project.gamingclub.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "games")
public class Games {

    @Id
    private String id;

    private String name;       // unique
    private double price;
    private String description;
    private int minPlayers;
    private int maxPlayers;
    private String status;     // ACTIVE / INACTIVE

    // Getters & Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public int getMinPlayers() { return minPlayers; }
    public void setMinPlayers(int minPlayers) { this.minPlayers = minPlayers; }

    public int getMaxPlayers() { return maxPlayers; }
    public void setMaxPlayers(int maxPlayers) { this.maxPlayers = maxPlayers; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    // Constructors
    public Games(String name, double price, String description, int minPlayers, int maxPlayers, String status) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.minPlayers = minPlayers;
        this.maxPlayers = maxPlayers;
        this.status = status;
    }
    public Games() {}
}
