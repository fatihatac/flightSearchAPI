package com.caseStudy.flightSearchAPI.business.concretes;

import com.caseStudy.flightSearchAPI.business.abstracts.FlightService;
import com.caseStudy.flightSearchAPI.business.requests.CreateFlightRequest;
import com.caseStudy.flightSearchAPI.business.requests.UpdateFlightRequest;
import com.caseStudy.flightSearchAPI.business.responses.GetAllFlightsResponse;
import com.caseStudy.flightSearchAPI.business.responses.GetByIdFlightResponse;
import com.caseStudy.flightSearchAPI.core.utilities.mapper.ModelMapperService;
import com.caseStudy.flightSearchAPI.dataAccess.abstracts.FlightRespository;
import com.caseStudy.flightSearchAPI.entities.concretes.Flight;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlightManager implements FlightService {
    private FlightRespository flightRespository;
    private ModelMapperService modelMapperService;

    public FlightManager(FlightRespository flightRespository, ModelMapperService modelMapperService) {
        this.flightRespository = flightRespository;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public List<GetAllFlightsResponse> getAll() {
        List<Flight> flights = flightRespository.findAll();

        List<GetAllFlightsResponse> flightsResponse = flights.stream()
                .map(flight -> modelMapperService.forResponse().map(flight, GetAllFlightsResponse.class)).collect(Collectors.toList());

        return flightsResponse;
    }

    @Override
    public GetByIdFlightResponse getById(int id) {
        Flight flight = flightRespository.findById(id).orElseThrow();
        GetByIdFlightResponse getByIdFlightResponse = modelMapperService.forResponse().map(flight, GetByIdFlightResponse.class);
        return getByIdFlightResponse;
    }

    @Override
    public List<Flight> searchFlights(int departureAirportId, int arrivalAirportId, LocalDate departureDate, LocalDate returnDate) {
//        List<Flight> flights = flightRespository.findByDepartureAirportIdAndArrivalAirportId(departureAirportId, arrivalAirportId);
//        System.out.println(departureDate.getClass());
//        return flightRespository.findByDepartureDateBetween(departureDate.atStartOfDay(), LocalDateTime.of(departureDate.getYear(), departureDate.getMonth(), departureDate.getDayOfMonth() + 1, 23, 59));
//

        List<Flight> flights = new ArrayList<>();
        flights.addAll(flightRespository.findByDepartureAirportIdAndArrivalAirportIdAndDepartureDateBetween(departureAirportId, arrivalAirportId, departureDate.atStartOfDay(),atEndOfDay(departureDate.atStartOfDay())));

        if (returnDate == null) {
            return flights;
        } else {
            flights.addAll(flightRespository.findByDepartureAirportIdAndArrivalAirportIdAndDepartureDateBetween(arrivalAirportId, departureAirportId,returnDate.atStartOfDay(),atEndOfDay(returnDate.atStartOfDay())));
            return flights;
        }
    }

    @Override
    public void add(CreateFlightRequest createFlightRequest) {
        Flight flight = modelMapperService.forRequests().map(createFlightRequest, Flight.class);
        flightRespository.save(flight);
    }

    @Override
    public void update(UpdateFlightRequest updateFlightRequest) {
        Flight flight = modelMapperService.forRequests().map(updateFlightRequest, Flight.class);
        flightRespository.save(flight);
    }

    @Override
    public void delete(int id) {
        flightRespository.deleteById(id);
    }

    LocalDateTime atEndOfDay(LocalDateTime localDateTime){
        LocalDateTime date = LocalDateTime.of(localDateTime.getYear(),localDateTime.getMonth(),localDateTime.getDayOfMonth(),23,59);
        return date;
    }
}
