package com.capg.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capg.dto.FlightDetailsDTO;
import com.capg.service.FlightDetailsService;



@RestController
@RequestMapping("/flights")
public class FlightDetailsController {
	
	@Autowired
	private FlightDetailsService flightDetailsService;
	
	@GetMapping("/getall")
	public List<FlightDetailsDTO> flights() {
		return flightDetailsService.getFlights();
	}
	
	
	@GetMapping("/get/{flightId}")
	public FlightDetailsDTO customerById(@PathVariable Integer flightId) {
		return flightDetailsService.getFlightbyId(flightId);
	}
	
	@GetMapping("/search")
	public List<FlightDetailsDTO> searchFlight(@RequestParam("query") String query) {
		return flightDetailsService.searchFlight(query);
	}
	
	@PostMapping("/save")
	public ResponseEntity<FlightDetailsDTO> save(@Valid @RequestBody FlightDetailsDTO flightDetailsDTO) {
		System.out.println(flightDetailsDTO);
		return new ResponseEntity<FlightDetailsDTO>(flightDetailsService.createFlight(flightDetailsDTO), HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{flightId}")
	public ResponseEntity<FlightDetailsDTO> update(@PathVariable Integer flightId, @Valid @RequestBody FlightDetailsDTO flightDetailsDTO) {
		return new ResponseEntity<FlightDetailsDTO>(flightDetailsService.updateFlight(flightId, flightDetailsDTO), HttpStatus.ACCEPTED);

	}
	
	@DeleteMapping("/delete/{flightId}")
	public String delete(@PathVariable Integer flightId) {
		flightDetailsService.deleteFlight(flightId);
		return " Flight with ID " + flightId + " was deleted sucessfully ";
	}

}
