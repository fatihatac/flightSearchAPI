package com.caseStudy.flightSearchAPI.dataAccess.abstracts;

import com.caseStudy.flightSearchAPI.entities.concretes.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@Repository
public interface FlightRespository extends JpaRepository<Flight,Integer> {
    List<Flight> findByDepartureAirportIdAndArrivalAirportIdAndDepartureDateBetween(int departureAirport, int arrivalAirport, LocalDateTime departureDate,LocalDateTime endOfDayDate);
    List<Flight> findByDepartureAirportIdAndArrivalAirportId(int departureAirportId, int arrivalAirportId);
    List<Flight> findByDepartureDateBetween(LocalDateTime departureDate, LocalDateTime endOfDayDate);

}


