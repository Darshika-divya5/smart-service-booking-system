package com.project.servicebooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.project.servicebooking.entity.ServiceEntity;

public interface ServiceRepository extends JpaRepository<ServiceEntity, Long> {

    //  SEARCH
    List<ServiceEntity> findByServiceNameContainingIgnoreCase(String name);

    // PAGINATION 
    Page<ServiceEntity> findAll(Pageable pageable);
    
    Page<ServiceEntity> findByServiceNameContainingIgnoreCase(String name, Pageable pageable);
}