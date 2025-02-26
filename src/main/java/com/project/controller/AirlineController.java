package com.project.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.bean.FlightBean;
import com.project.entity.FlightEntity;
import com.project.service.AirlineService;

@RestController
public class AirlineController {
	
	@Autowired
	private AirlineService airlineService;
	public static final Logger logger = LoggerFactory.getLogger(AirlineController.class);
	
	@RequestMapping(value = "airline/controller/{airline}/getallflights", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<FlightBean>> getAllFlights(@PathVariable String airline){
		List<FlightBean> flightDetails = airlineService.getAllFlights(airline);
		return new ResponseEntity<List<FlightBean>>(flightDetails, HttpStatus.OK);
	}
	
	@RequestMapping(value = "airline/controller/{airline}/registerflight", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> createFlight(@PathVariable String airline, @RequestBody FlightEntity flight){
		String response = airlineService.newFlightRegistration(airline, flight);
		return ResponseEntity.ok(response);
	}
	
	@RequestMapping(value = "airline/controller/{airline}/(id}")
	public ResponseEntity<FlightBean> getFlightByID(@PathVariable String airline, @PathVariable Integer id){
		FlightBean result = airlineService.getFlightByID(airline, id);
		return new ResponseEntity<FlightBean>(result, HttpStatus.OK);
		
	}
	
}
