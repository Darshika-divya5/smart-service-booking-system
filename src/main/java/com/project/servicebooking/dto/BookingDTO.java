package com.project.servicebooking.dto;

import java.time.LocalDate;

public class BookingDTO {

    private Long id;
    private String userName;
    private String serviceName;
    private String providerName;
    private LocalDate bookingDate;
    private String status;

    public BookingDTO(Long id, String userName, String serviceName,
                      String providerName, LocalDate bookingDate, String status) {
        this.id = id;
        this.userName = userName;
        this.serviceName = serviceName;
        this.providerName = providerName;
        this.bookingDate = bookingDate;
        this.status = status;
    }

    // getters
    public Long getId() { return id; }
    public String getUserName() { return userName; }
    public String getServiceName() { return serviceName; }
    public String getProviderName() { return providerName; }
    public LocalDate getBookingDate() { return bookingDate; }
    public String getStatus() { return status; }
}