package com.caseStudy.flightSearchAPI.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdFlightResponse {
    private int id;
    private String departureAirportName;
    private String arrivalAirportName;
    private LocalDateTime departureDate;
    private LocalDateTime arrivalDate;
    private double price;
}
