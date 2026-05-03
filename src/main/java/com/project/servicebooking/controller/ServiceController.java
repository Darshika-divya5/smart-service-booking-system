package com.project.servicebooking.controller;

import java.util.List;
import org.springframework.data.domain.Page;   
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.project.servicebooking.entity.ServiceEntity;
import com.project.servicebooking.repository.ServiceRepository;
import com.project.servicebooking.service.ServiceService;



@RestController
@RequestMapping("/api/services")
public class ServiceController {

    @Autowired
    private ServiceRepository repo;
    
    @Autowired
    private ServiceService service;

    //  CREATE SERVICE
    @PostMapping
    public ServiceEntity create(@RequestBody ServiceEntity s) {
        return repo.save(s);
    }

    //  GET ALL SERVICES
    @GetMapping
    public List<ServiceEntity> getAll() {
        return repo.findAll();
    }
    
    
    @GetMapping("/search")
    public List<ServiceEntity> search(@RequestParam String name) {
        return service.searchServices(name);
    }
    
    @GetMapping("/page")
    public Page<ServiceEntity> getServices(
            @RequestParam int page,
            @RequestParam int size) {
        return service.getServicesWithPagination(page, size);
    }
    @GetMapping("/sorted")
    public List<ServiceEntity> getSortedServices() {
        return service.getServicesSorted();
    }
    @GetMapping("/search/page")
    public Page<ServiceEntity> searchWithPagination(
            @RequestParam String name,
            @RequestParam int page,
            @RequestParam int size) {
        return service.searchAndPaginate(name, page, size);
    }
    
}
