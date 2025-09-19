package com.project.gamingclub.controller;

import com.project.gamingclub.entity.Collections;
import com.project.gamingclub.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/collections")
public class CollectionController {

    @Autowired
    private CollectionService collectionService;

    @GetMapping
    public List<Collections> getAll() {
        return collectionService.findAll();
    }

    @GetMapping("/{date}")
    public Collections getByDate(@PathVariable String date) {
        return collectionService.findByDate(LocalDate.parse(date));
    }
}
