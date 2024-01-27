package com.caseStudy.flightSearchAPI.business.requests;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateAirportRequest {
    private int id;
    private int cityId;
}
