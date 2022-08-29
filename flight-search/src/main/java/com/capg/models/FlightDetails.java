package com.capg.models;





import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import com.capg.dto.FlightDetailsDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Document(collection = "FlightDetails")
public class FlightDetails {
	
	@Transient
    public static final String SEQUENCE_NAME = "users_sequence";
	
	@Id
	private int id;
	
	@Field
	private String departure_location;
	
	@Field
	private String arrival_location;
	
	
	public FlightDetails (FlightDetailsDTO flightDetailsDTO) {
		this.id = flightDetailsDTO.getId();
		this.arrival_location= flightDetailsDTO.getArrival_location();
		this.departure_location = flightDetailsDTO.getDeparture_location();
	}

}
