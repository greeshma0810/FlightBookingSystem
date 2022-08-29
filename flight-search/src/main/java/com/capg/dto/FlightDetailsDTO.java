package com.capg.dto;

import com.capg.models.FlightDetails;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FlightDetailsDTO {
	
	private int id;
	private String departure_location;
	private String arrival_location;
	
	
	public FlightDetailsDTO(FlightDetails flightDetails) {
		this.id = flightDetails.getId();
		this.arrival_location = flightDetails.getArrival_location();
		this.departure_location = flightDetails.getDeparture_location();
	}

}
