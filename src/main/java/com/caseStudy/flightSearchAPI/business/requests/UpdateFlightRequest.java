package com.caseStudy.flightSearchAPI.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateFlightRequest {
    private int id;
    private int departureAirportId;
    private int arrivalAirportId;
    private LocalDateTime departureDate;
    private LocalDateTime arrivalDate;
    private double price;
}
