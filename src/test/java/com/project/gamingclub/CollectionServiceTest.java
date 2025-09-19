package com.project.gamingclub;

import com.project.gamingclub.entity.Collections;
import com.project.gamingclub.repository.CollectionRepository;
import com.project.gamingclub.service.CollectionService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CollectionServiceTest {

    @Mock
    private CollectionRepository collectionRepo;

    @InjectMocks
    private CollectionService collectionService;

    private Collections collection;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        collection = new Collections();
        collection.setId("c1");
        collection.setDate(LocalDate.now());
        collection.setAmount(500.0);
    }

    @Test
    void testFindAllCollections() {
        when(collectionRepo.findAll()).thenReturn(List.of(collection));

        List<Collections> result = collectionService.findAll();

        assertEquals(1, result.size());
        assertEquals(500.0, result.get(0).getAmount());
    }

    @Test
    void testFindByDate() {
        LocalDate today = LocalDate.now();
        when(collectionRepo.findByDate(today)).thenReturn(collection);

        Collections found = collectionService.findByDate(today);

        assertNotNull(found);
        assertEquals(today, found.getDate());
        assertEquals(500.0, found.getAmount());
    }
}
