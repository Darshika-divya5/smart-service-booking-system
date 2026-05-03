package com.project.servicebooking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.servicebooking.entity.Booking;
import com.project.servicebooking.entity.BookingStatus;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findByUserId(Long userId);

    // ✅ FIX: ENUM use karo
    List<Booking> findByStatus(BookingStatus status);
}