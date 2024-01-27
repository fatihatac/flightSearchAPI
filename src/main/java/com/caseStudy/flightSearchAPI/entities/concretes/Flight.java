package com.caseStudy.flightSearchAPI.entities.concretes;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Table(name="flights")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "departure_airport_id")
    @JsonManagedReference
    private Airport departureAirport;

    @ManyToOne
    @JoinColumn(name = "arrival_airport_id")
    @JsonManagedReference
    private Airport arrivalAirport;

    @Column(name="departure_date")
    private LocalDateTime departureDate;

    @Column(name="arrival_date")
    private LocalDateTime arrivalDate;

    @Column(name="price", nullable = false)
    private double price;
}
