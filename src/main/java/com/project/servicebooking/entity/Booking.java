package com.project.servicebooking.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate bookingDate;

    @Enumerated(EnumType.STRING)
    private BookingStatus status;

    @ManyToOne
    private User user;

    @ManyToOne
    private ServiceEntity service;

    @ManyToOne
    private Provider provider;

	public Long getId() {
		return id;
	}

	  // getters setters
	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}

	public BookingStatus getStatus() {
	    return status;
	}

	public void setStatus(BookingStatus status) {
	    this.status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ServiceEntity getService() {
		return service;
	}

	public void setService(ServiceEntity service) {
		this.service = service;
	}

	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}
    
    
}