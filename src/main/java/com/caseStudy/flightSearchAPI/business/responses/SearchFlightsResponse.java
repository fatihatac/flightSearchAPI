package com.caseStudy.flightSearchAPI.business.responses;

import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchFlightsResponse {
    private int departureAirportId;
    private int arrivalAirportId;
    private LocalDate departureDate;

    @Nullable
    private LocalDate returnDate;
}
