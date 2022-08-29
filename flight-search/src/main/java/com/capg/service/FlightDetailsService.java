package com.capg.service;

import java.util.List;



import com.capg.dto.FlightDetailsDTO;

public interface FlightDetailsService {
	
	List<FlightDetailsDTO> getFlights();
	
	FlightDetailsDTO getFlightbyId(Integer flightId);
	
	FlightDetailsDTO createFlight(FlightDetailsDTO flightDetailsDTO);
	
	FlightDetailsDTO updateFlight(Integer flightId, FlightDetailsDTO flightDetailsDTO);
	
	void deleteFlight(Integer flightId);
	
	List<FlightDetailsDTO> searchFlight(String query);

}
