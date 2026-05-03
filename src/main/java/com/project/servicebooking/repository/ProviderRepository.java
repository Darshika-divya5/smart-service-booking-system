package com.project.servicebooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.servicebooking.entity.Provider;

public interface ProviderRepository extends JpaRepository<Provider, Long> {
}
