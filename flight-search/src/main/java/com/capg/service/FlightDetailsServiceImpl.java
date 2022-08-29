package com.capg.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.dto.FlightDetailsDTO;
import com.capg.exception.FlightDetailsNotFoundException;
import com.capg.models.FlightDetails;
import com.capg.repository.FlightDetailsRepository;


@Service
public class FlightDetailsServiceImpl implements FlightDetailsService {

	
	@Autowired
	private FlightDetailsRepository flightDetailsRepository;
	
	@Autowired
    private SequenceGeneratorService sequenceGeneratorService;
	
	@Override
	public List<FlightDetailsDTO> getFlights() {
		List<FlightDetails> flights = flightDetailsRepository.findAll();
		return flights.stream().map(FlightDetailsDTO::new).collect(Collectors.toList());
	}

	@Override
	public FlightDetailsDTO getFlightbyId(Integer flightId) {
		FlightDetails flight = flightDetailsRepository.findById(flightId).orElseThrow(
				() -> new FlightDetailsNotFoundException("Flight Does Not Exist With Given Id : " + flightId));
		return new FlightDetailsDTO(flight);
	}

	@Override
	public FlightDetailsDTO createFlight(FlightDetailsDTO flightDetailsDTO) {
//		System.out.println(flightDetailsDTO);
		FlightDetails flight = new FlightDetails(flightDetailsDTO);
		 flight.setId(sequenceGeneratorService.getSequenceNumber(FlightDetails.SEQUENCE_NAME));
		return new FlightDetailsDTO(flightDetailsRepository.save(flight));
	}

	@Override
	public FlightDetailsDTO updateFlight(Integer flightId, FlightDetailsDTO flightDetailsDTO) {
		FlightDetails flight = flightDetailsRepository.findById(flightId).orElseThrow(
				() -> new FlightDetailsNotFoundException("Flight Does Not Exist With Given Id : " + flightId));
		 
		Optional<FlightDetails> optionalFlights = flightDetailsRepository.findById(flightId);
	        flightDetailsRepository.delete(flight);

	        if (optionalFlights.isPresent()) {
	            FlightDetails flightsSave = optionalFlights.get();
	            
	            flightsSave.setId(flight.getId());
	            flightsSave.setArrival_location(flightDetailsDTO.getArrival_location() != null ? flightDetailsDTO.getArrival_location() : flightsSave.getArrival_location());
	            flightsSave.setDeparture_location(flightDetailsDTO.getDeparture_location() !=null ? flightDetailsDTO.getDeparture_location() : flightsSave.getDeparture_location());

	           

	            flightDetailsRepository.save(flightsSave);
	            return new FlightDetailsDTO(flightsSave);
	        }
	        return new FlightDetailsDTO(flight);
	    }
	

	@Override
	public void deleteFlight(Integer flightId) {
		FlightDetails flight =flightDetailsRepository.findById(flightId).orElseThrow(
				() -> new FlightDetailsNotFoundException("Flight Does Not Exist With Given Id : " + flightId));
		flightDetailsRepository.delete(flight);
		
	}

	@Override
	public List<FlightDetailsDTO> searchFlight(String query) {
		List<FlightDetails> flights = flightDetailsRepository.searchFlight(query);
		return flights.stream().map(FlightDetailsDTO::new).collect(Collectors.toList());
	}
	
	

}
