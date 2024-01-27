package com.caseStudy.flightSearchAPI.webApi.controllers;


import com.caseStudy.flightSearchAPI.business.abstracts.FlightService;
import com.caseStudy.flightSearchAPI.business.concretes.FlightManager;
import com.caseStudy.flightSearchAPI.business.requests.CreateFlightRequest;
import com.caseStudy.flightSearchAPI.business.requests.UpdateFlightRequest;
import com.caseStudy.flightSearchAPI.business.responses.GetAllFlightsResponse;
import com.caseStudy.flightSearchAPI.business.responses.GetByIdFlightResponse;
import com.caseStudy.flightSearchAPI.business.responses.SearchFlightsResponse;
import com.caseStudy.flightSearchAPI.entities.concretes.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/flights")
public class FlightsController {
    private FlightService flightService;

    @Autowired
    public FlightsController(FlightService flightService) {
        this.flightService = flightService;
    }
    @GetMapping()
    public List<GetAllFlightsResponse> getAll(){
        return  flightService.getAll();
    }
    @GetMapping("/{id}")
    public GetByIdFlightResponse getById(@PathVariable int id){
        return  flightService.getById(id);
    }

    @GetMapping("/search")
    public List<Flight> searchFlights(
            @RequestParam("departureAirportId") int departureAirportId,
            @RequestParam("arrivalAirportId") int arrivalAirportId,
            @RequestParam(value = "departureDate",required = false) LocalDate departureDate,
            @RequestParam(value = "returnDate", required = false)  LocalDate returnDate) {

        return  flightService.searchFlights(departureAirportId, arrivalAirportId, departureDate, returnDate);
    }

    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody CreateFlightRequest createFlightRequest){
        flightService.add(createFlightRequest);
    }
    @PutMapping()
    public void update(@RequestBody UpdateFlightRequest updateFlightRequest){
        flightService.update(updateFlightRequest);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        flightService.delete(id);
    }
}
