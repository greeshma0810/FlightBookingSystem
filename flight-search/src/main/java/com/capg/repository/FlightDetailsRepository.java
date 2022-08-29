package com.capg.repository;

import java.util.List;



import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.capg.models.FlightDetails;

@Repository
public interface FlightDetailsRepository extends MongoRepository<FlightDetails, Integer> {

	@Query("SELECT a FROM FlightDetails a WHERE " + 
			"a.arrival_location LIKE CONCAT('%', :query, '%')"
			+ "OR a.departure_location LIKE CONCAT('%', ':query', '%')" 
			 )
	
	List<FlightDetails> searchFlight(String query);
}
