package com.project.servicebooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.project.servicebooking.entity.Provider;
import com.project.servicebooking.repository.ProviderRepository;

import java.util.List;

@RestController
@RequestMapping("/api/providers")
public class ProviderController {

    @Autowired
    private ProviderRepository repo;

    @PostMapping
    public Provider create(@RequestBody Provider p) {
        return repo.save(p);
    }

    @GetMapping
    public List<Provider> getAll() {
        return repo.findAll();
    }
}