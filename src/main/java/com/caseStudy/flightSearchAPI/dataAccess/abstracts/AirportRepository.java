package com.caseStudy.flightSearchAPI.dataAccess.abstracts;

import com.caseStudy.flightSearchAPI.entities.concretes.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportRepository extends JpaRepository<Airport,Integer> {
}
