package com.project.gamingclub;

import com.project.gamingclub.entity.Games;
import com.project.gamingclub.repository.GameRepsitory;
import com.project.gamingclub.service.GameService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class GameServiceTest {

    @Mock
    private GameRepsitory gameRepo;

    @InjectMocks
    private GameService gameService;

    private Games game;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        game = new Games("FIFA 23", 100, "Football simulation", 1, 4, "ACTIVE");
        game.setId("101");
    }

    @Test
    void testCreateGame() {
        when(gameRepo.save(any(Games.class))).thenReturn(game);

        Games saved = gameService.create(game);

        assertNotNull(saved);
        assertEquals("FIFA 23", saved.getName());
    }

    @Test
    void testFindGameById() {
        when(gameRepo.findById("101")).thenReturn(Optional.of(game));

        Games found = gameService.findById("101");

        assertEquals("FIFA 23", found.getName());
    }

    @Test
    void testFindAllGames() {
        when(gameRepo.findAll()).thenReturn(List.of(game));

        List<Games> games = gameService.findAll();

        assertEquals(1, games.size());
    }
}
