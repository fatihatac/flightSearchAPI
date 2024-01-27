package com.caseStudy.flightSearchAPI.business.abstracts;

import com.caseStudy.flightSearchAPI.business.requests.CreateFlightRequest;
import com.caseStudy.flightSearchAPI.business.requests.UpdateFlightRequest;
import com.caseStudy.flightSearchAPI.business.responses.GetAllFlightsResponse;
import com.caseStudy.flightSearchAPI.business.responses.GetByIdFlightResponse;
import com.caseStudy.flightSearchAPI.entities.concretes.Flight;

import java.time.LocalDate;
import java.util.List;

public interface FlightService {
    List<GetAllFlightsResponse> getAll();
    GetByIdFlightResponse getById(int id);
    List<Flight> searchFlights(int departureAirportId, int arrivalAirportId, LocalDate departureDate, LocalDate returnDate);
    void add(CreateFlightRequest createFlightRequest);
    void update(UpdateFlightRequest updateFlightRequest);
    void delete(int id);
}
