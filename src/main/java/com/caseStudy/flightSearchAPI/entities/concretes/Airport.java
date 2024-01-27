package com.caseStudy.flightSearchAPI.entities.concretes;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name="airports")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Airport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    private String city;

    @OneToMany(mappedBy = "departureAirport")
    @JsonBackReference
    private List<Flight> departureFlights;

    @OneToMany(mappedBy = "arrivalAirport")
    @JsonBackReference
    private List<Flight> arrivalFlights;

}
