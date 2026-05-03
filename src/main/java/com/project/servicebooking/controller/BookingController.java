package com.project.servicebooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.project.servicebooking.dto.BookingDTO;
import com.project.servicebooking.entity.Booking;
import com.project.servicebooking.service.BookingService;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private BookingService service;

    //  CREATE
    @PostMapping
    public Booking createBooking(
            @RequestParam Long userId,
            @RequestParam Long serviceId,
            @RequestParam Long providerId) {

        return service.createBooking(userId, serviceId, providerId);
    }

    //  GET ALL
    @GetMapping
    public List<BookingDTO> getAll() {
        return service.getAllBookings();
    }

    //  UPDATE
    @PutMapping("/{id}")
    public Booking updateStatus(@PathVariable Long id,
                                @RequestParam String status) {
        return service.updateStatus(id, status);
    }

    //  DELETE
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.deleteBooking(id);
        return "Booking deleted";
    }

    // FILTER USER
    @GetMapping("/user/{userId}")
    public List<BookingDTO> getByUser(@PathVariable Long userId) {
        return service.getBookingsByUser(userId);
    }

    //  FILTER STATUS
    @GetMapping("/status/{status}")
    public List<BookingDTO> getByStatus(@PathVariable String status) {
        return service.getBookingsByStatus(status);
    }
}