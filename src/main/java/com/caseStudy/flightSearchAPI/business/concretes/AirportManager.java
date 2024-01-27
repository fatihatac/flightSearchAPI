package com.caseStudy.flightSearchAPI.business.concretes;

import com.caseStudy.flightSearchAPI.business.abstracts.AirportService;
import com.caseStudy.flightSearchAPI.business.requests.CreateAirportRequest;
import com.caseStudy.flightSearchAPI.business.requests.UpdateAirportRequest;
import com.caseStudy.flightSearchAPI.business.responses.GetAllAirportsResponse;
import com.caseStudy.flightSearchAPI.business.responses.GetByIdAirportResponse;
import com.caseStudy.flightSearchAPI.dataAccess.abstracts.AirportRepository;
import com.caseStudy.flightSearchAPI.entities.concretes.Airport;
import com.caseStudy.flightSearchAPI.core.utilities.mapper.ModelMapperService;
import com.caseStudy.flightSearchAPI.entities.concretes.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AirportManager implements AirportService {
    private AirportRepository airportRepository;
    private ModelMapperService modelMapperService;

    @Autowired
    public AirportManager(AirportRepository airportRepository, ModelMapperService modelMapperService) {
        this.airportRepository = airportRepository;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public List<GetAllAirportsResponse> getAll() {
        List<Airport> airports = airportRepository.findAll();

        List<GetAllAirportsResponse> airportsResponse = airports.stream()
                .map(airport -> modelMapperService.forResponse().map(airport, GetAllAirportsResponse.class)).collect(Collectors.toList());

        return airportsResponse;
    }

    @Override
    public GetByIdAirportResponse getById(int id) {
        Airport airport = airportRepository.findById(id).orElseThrow();
        GetByIdAirportResponse getByIdAirportResponse = modelMapperService.forResponse().map(airport, GetByIdAirportResponse.class);
        return  getByIdAirportResponse;
    }

    @Override
    public List<Flight> searchFlights(int departureAirportId, int arrivalAirportId, LocalDateTime departureDateTime, LocalDateTime returnDateTime) {
        return null;
    }

    @Override
    public void add(CreateAirportRequest createAirportRequest) {
        Airport airport = modelMapperService.forRequests().map(createAirportRequest,Airport.class);
        airportRepository.save(airport);
    }

    @Override
    public void update(UpdateAirportRequest updateAirportRequest) {
        Airport airport = modelMapperService.forRequests().map(updateAirportRequest,Airport.class);
        airportRepository.save(airport);
    }

    @Override
    public void delete(int id) {
        airportRepository.deleteById(id);
    }
}
