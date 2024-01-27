package com.caseStudy.flightSearchAPI.core.utilities.mapper;


import org.modelmapper.ModelMapper;


public interface ModelMapperService {
    ModelMapper forResponse();

    ModelMapper forRequests();
}
