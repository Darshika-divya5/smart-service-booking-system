package com.project.servicebooking.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.servicebooking.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByUsername(String username);
}