package com.project.gamingclub.service;

import com.project.gamingclub.entity.Games;
import com.project.gamingclub.repository.GameRepsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepsitory gameRepo;

    public Games create(Games game) {
        if (gameRepo.findByName(game.getName()) != null) {
            throw new RuntimeException("Game name must be unique!");
        }
        return gameRepo.save(game);
    }

    public List<Games> findAll() {
        return gameRepo.findAll();
    }

    public Games findById(String id) {
        return gameRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Game not found"));
    }

    public Games update(String id, Games updated) {
        Games game = findById(id);
        game.setName(updated.getName());
        game.setPrice(updated.getPrice());
        game.setDescription(updated.getDescription());
        game.setMinPlayers(updated.getMinPlayers());
        game.setMaxPlayers(updated.getMaxPlayers());
        game.setStatus(updated.getStatus());
        return gameRepo.save(game);
    }

    public void delete(String id) {
        gameRepo.deleteById(id);
    }
}
