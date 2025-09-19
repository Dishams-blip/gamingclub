package com.project.gamingclub.controller;

import com.project.gamingclub.entity.Games;
import com.project.gamingclub.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/games")
public class GameController {

    @Autowired
    private GameService gameService;

    @PostMapping
    public Games create(@RequestBody Games game) {
        return gameService.create(game);
    }

    @GetMapping
    public List<Games> getAll() {
        return gameService.findAll();
    }

    @GetMapping("/{id}")
    public Games getById(@PathVariable String id) {
        return gameService.findById(id);
    }

    @PutMapping("/{id}")
    public Games update(@PathVariable String id, @RequestBody Games game) {
        return gameService.update(id, game);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        gameService.delete(id);
    }
}
