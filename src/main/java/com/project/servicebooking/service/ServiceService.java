package com.project.servicebooking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.servicebooking.entity.ServiceEntity;
import com.project.servicebooking.repository.ServiceRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@Service
public class ServiceService {

    @Autowired
    private ServiceRepository serviceRepo;

    //  CREATE
    public ServiceEntity createService(ServiceEntity service) {
        return serviceRepo.save(service);
    }

    //  GET ALL
    public List<ServiceEntity> getAllServices() {
        return serviceRepo.findAll();
    }

    //  SEARCH (IMPORTANT 🔥)
    public List<ServiceEntity> searchServices(String name) {
        return serviceRepo.findByServiceNameContainingIgnoreCase(name);
    }

    //  DELETE
    public void deleteService(Long id) {
        serviceRepo.deleteById(id);
    }
    
    public Page<ServiceEntity> getServicesWithPagination(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return serviceRepo.findAll(pageable);
    }
   

    public List<ServiceEntity> getServicesSorted() {
        return serviceRepo.findAll(Sort.by("serviceName").ascending());
    }
    public Page<ServiceEntity> searchAndPaginate(String name, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return serviceRepo.findByServiceNameContainingIgnoreCase(name, pageable);
    }
    
}