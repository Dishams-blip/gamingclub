package com.project.gamingclub.service;

import com.project.gamingclub.entity.Collections;
import com.project.gamingclub.repository.CollectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class CollectionService {

    @Autowired
    private CollectionRepository collectionRepo;

    public Collections findByDate(LocalDate date) {
        return collectionRepo.findByDate(date);
    }

    public List<Collections> findAll() {
        return collectionRepo.findAll();
    }
}
