package com.caseStudy.flightSearchAPI.webApi.controllers;


import com.caseStudy.flightSearchAPI.business.abstracts.AirportService;
import com.caseStudy.flightSearchAPI.business.requests.CreateAirportRequest;
import com.caseStudy.flightSearchAPI.business.requests.UpdateAirportRequest;
import com.caseStudy.flightSearchAPI.business.responses.GetAllAirportsResponse;
import com.caseStudy.flightSearchAPI.business.responses.GetByIdAirportResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/airports")
public class AirportsController {
    private AirportService airportService;

    @Autowired
    public AirportsController(AirportService airportService) {
        this.airportService = airportService;
    }

    @GetMapping()
    public List<GetAllAirportsResponse> getAll() {
        return airportService.getAll();
    }
    @GetMapping("/{id}")
    public GetByIdAirportResponse getById(@PathVariable int id) {
        return airportService.getById(id);
    }
    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody CreateAirportRequest createAirportRequest){
        airportService.add(createAirportRequest);
    }
    @PutMapping()
    public void update(@RequestBody UpdateAirportRequest updateAirportRequest){
        airportService.update(updateAirportRequest);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        airportService.delete(id);
    }
}
