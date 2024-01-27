package com.caseStudy.flightSearchAPI.business.abstracts;

import com.caseStudy.flightSearchAPI.business.requests.CreateAirportRequest;
import com.caseStudy.flightSearchAPI.business.requests.UpdateAirportRequest;
import com.caseStudy.flightSearchAPI.business.responses.GetAllAirportsResponse;
import com.caseStudy.flightSearchAPI.business.responses.GetByIdAirportResponse;
import com.caseStudy.flightSearchAPI.entities.concretes.Flight;

import java.time.LocalDateTime;
import java.util.List;

public interface AirportService {
    List<GetAllAirportsResponse> getAll();
    GetByIdAirportResponse getById(int id);
    List<Flight> searchFlights(int departureAirportId, int arrivalAirportId, LocalDateTime departureDateTime, LocalDateTime returnDateTime);
    void add(CreateAirportRequest createAirportRequest);
    void update(UpdateAirportRequest updateAirportRequest);
    void delete(int id);
}
