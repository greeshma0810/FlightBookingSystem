package com.capg.service;

import com.capg.entity.Flights;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FlightsInfo {

    @Autowired
    private RestTemplate restTemplate;

   
    public Flights getFlightDetails(int flightId) {
        Flights flights = restTemplate.getForObject("http://flight-search/flights/get/" + flightId,
                Flights.class);
        return flights;
    }
}