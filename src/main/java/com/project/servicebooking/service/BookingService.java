package com.project.servicebooking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.servicebooking.dto.BookingDTO;
import com.project.servicebooking.entity.*;
import com.project.servicebooking.repository.*;

import java.time.LocalDate;
import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepo;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private ServiceRepository serviceRepo;

    @Autowired
    private ProviderRepository providerRepo;

    // 🔥 CREATE BOOKING
    public Booking createBooking(Long userId, Long serviceId, Long providerId) {

        User user = userRepo.findById(userId).orElse(null);
        ServiceEntity service = serviceRepo.findById(serviceId).orElse(null);
        Provider provider = providerRepo.findById(providerId).orElse(null);

        Booking booking = new Booking();
        booking.setUser(user);
        booking.setService(service);
        booking.setProvider(provider);
        booking.setBookingDate(LocalDate.now());
        booking.setStatus(BookingStatus.PENDING);

        return bookingRepo.save(booking);
    }

    // 🔥 GET ALL BOOKINGS
    public List<BookingDTO> getAllBookings() {
        List<Booking> bookings = bookingRepo.findAll();

        return bookings.stream()
                .map(b -> new BookingDTO(
                        b.getId(),
                        b.getUser() != null ? b.getUser().getName() : "N/A",
                        b.getService() != null ? b.getService().getServiceName() : "N/A",
                        b.getProvider() != null ? b.getProvider().getName() : "N/A",
                        b.getBookingDate(),
                        b.getStatus().name()
                ))
                .toList();
    }

    // 🔥 UPDATE STATUS
    public Booking updateStatus(Long id, String status) {
        Booking booking = bookingRepo.findById(id).orElse(null);

        if (booking != null) {
            try {
                BookingStatus newStatus = BookingStatus.valueOf(status.toUpperCase());
                booking.setStatus(newStatus);
                return bookingRepo.save(booking);
            } catch (IllegalArgumentException e) {
                throw new RuntimeException("Invalid status value!");
            }
        }

        return null;
    }

    // 🔥 DELETE
    public void deleteBooking(Long id) {
        bookingRepo.deleteById(id);
    }

    // 🔥 FILTER BY USER
    public List<BookingDTO> getBookingsByUser(Long userId) {
        List<Booking> bookings = bookingRepo.findByUserId(userId);

        return bookings.stream()
                .map(b -> new BookingDTO(
                        b.getId(),
                        b.getUser() != null ? b.getUser().getName() : "N/A",
                        b.getService() != null ? b.getService().getServiceName() : "N/A",
                        b.getProvider() != null ? b.getProvider().getName() : "N/A",
                        b.getBookingDate(),
                        b.getStatus().name()
                ))
                .toList();
    }

    // 🔥 FILTER BY STATUS
    public List<BookingDTO> getBookingsByStatus(String status) {

        BookingStatus statusEnum = BookingStatus.valueOf(status.toUpperCase());

        List<Booking> bookings = bookingRepo.findByStatus(statusEnum);

        return bookings.stream()
                .map(b -> new BookingDTO(
                        b.getId(),
                        b.getUser() != null ? b.getUser().getName() : "N/A",
                        b.getService() != null ? b.getService().getServiceName() : "N/A",
                        b.getProvider() != null ? b.getProvider().getName() : "N/A",
                        b.getBookingDate(),
                        b.getStatus().name()
                ))
                .toList();
    }
}