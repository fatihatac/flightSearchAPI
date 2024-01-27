package com.caseStudy.flightSearchAPI.business.responses;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdAirportResponse {
    private int id;
    private String cityName;
}
