package com.project.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.bean.CustomerBean;
import com.project.service.CustomerService;

@RestController
public class AdminController {
	
	public static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	private CustomerService customerService;
	
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

}