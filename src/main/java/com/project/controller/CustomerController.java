package com.project.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.entity.*;
import com.project.service.*;

@CrossOrigin(origins = "*")
@RestController
public class CustomerController {
	public static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
	
	public CustomerController(CustomerService customerservice) {
		this.customerService = customerservice;
	}
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(value="customer/controller/registration", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> newUserRegistration(@RequestBody CustomerEntity customer){
		String response = customerService.newUserRegistration(customer);
		return ResponseEntity.ok(response);
	}
	
	@RequestMapping(value="customer/controller/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> existingUserLogin(@RequestBody CustomerEntity customer) {
		logger.info("Received Login Request - Email: " + customer.getEmail() + ", Password: " + customer.getPassword());
	    String response = customerService.existingUserLogin(customer.getEmail(), customer.getPassword());
	    return ResponseEntity.ok(response);
	}
	
	
}
