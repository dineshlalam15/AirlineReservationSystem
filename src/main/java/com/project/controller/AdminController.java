package com.project.controller;

import java.util.List;

import javax.print.attribute.standard.Media;

import org.apache.catalina.connector.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.bean.AirlineBean;
import com.project.bean.CustomerBean;
import com.project.bean.FlightBean;
import com.project.service.AirlineService;
import com.project.service.CustomerService;
import com.project.service.FlightService;

@RestController
public class AdminController {
	
	public static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	private CustomerService customerService;
	@Autowired
	private AirlineService airlineService;
	@Autowired
	private FlightService flightService;
	
	@RequestMapping(value = "/home", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
	public String index() {
	    return "Hello, Welcome to Spring Boot Airline Reservation System API!";
	}
	
//	CUSTOMERS:
	@RequestMapping(value="/admin/controller/getallcustomers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CustomerBean>> getAllCustomers(){
		List<CustomerBean> customerDetails = customerService.getAllCustomers();
		return new ResponseEntity<List<CustomerBean>>(customerDetails, HttpStatus.OK);
	}
	
	@RequestMapping(value="admin/controller/getcustomerbyid/{customerId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CustomerBean> getCustomerDetailsByID(@PathVariable String customerId){
		CustomerBean customerDetails = customerService.getCustomerByID(customerId);
		return new ResponseEntity<CustomerBean>(customerDetails, HttpStatus.OK);
	}
	
	@RequestMapping(value="admin/controller/deleteCustomerbyid/{customerId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deleteCustomer(@PathVariable String customerId){
		String response = customerService.deleteCustomerByID(customerId);
		return ResponseEntity.ok(response);
	}
	
//	AIRLINES:
	@RequestMapping(value="admin/controller/getallairlines", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AirlineBean>> getAllAirlines(){
		List<AirlineBean> airlineDetails = airlineService.getAllAirlines();
		return new ResponseEntity<List<AirlineBean>>(airlineDetails,HttpStatus.OK);
	}
	
//	FLIGHTS:
	@RequestMapping(value = "admin/controller/getallflights", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<FlightBean>> getAllFlights(){
		List<FlightBean> flightDetails = flightService.getAllFlights();
		return new ResponseEntity<List<FlightBean>>(flightDetails, HttpStatus.OK);
	}
	
	@RequestMapping(value = "admin/controller/{airline}/getallflights", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<FlightBean>> getAllFlightsByAirline(@PathVariable String airline){
		List<FlightBean> flightDetails = airlineService.getAllFlights(airline);
		return new ResponseEntity<List<FlightBean>>(flightDetails, HttpStatus.OK);
	}

}