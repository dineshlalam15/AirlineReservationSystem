package com.project.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.bean.CustomerBean;
import com.project.dao.CustomerDAO;
import com.project.entity.CustomerEntity;

@Service
public class CustomerService {
	
	public static final Logger logger = org.slf4j.LoggerFactory.getLogger(CustomerService.class);
	
	@Autowired
	private CustomerDAO customerDAO;
	private final BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	public CustomerService(CustomerDAO customerDAO, BCryptPasswordEncoder passwordEncoder) {
		this.customerDAO = customerDAO;
		this.passwordEncoder = passwordEncoder;
	}
	
	public List<CustomerBean> getAllCustomers(){
		List<CustomerBean> customers = new ArrayList<>();
		List<CustomerEntity> customerEntities = customerDAO.findAll();
		if(!customerEntities.isEmpty()) {
			for(CustomerEntity element: customerEntities) {
				CustomerBean cb = new CustomerBean();
				BeanUtils.copyProperties(element, cb);
				customers.add(cb);
			}
		}
		return customers;
	}
	
	public CustomerBean getCustomerByID(String customerId) {
		CustomerBean cb = new CustomerBean();
		Optional<CustomerEntity> entity  = customerDAO.findById(customerId);
		if(!entity.isPresent()) {
			logger.info("Customer with this id doesn't exist");
			return null;
		}
		CustomerEntity customer = entity.get();
		BeanUtils.copyProperties(customer, cb);
		return cb;
	}
	
	public String deleteCustomerByID(String customerId) {
	    Optional<CustomerEntity> entity = customerDAO.findById(customerId);
	    if (entity.isEmpty()) {
	        return "Invalid CustomerID";
	    }
	    logger.info("Deleting Customer with ID: {}", customerId);
	    customerDAO.deleteById(customerId);
	    
	    return "Customer Deleted Successfully";
	}
	
	public String newUserRegistration(CustomerEntity customer) {
		String userEmail = customer.getEmail();
		if(customerDAO.existsByEmail(userEmail)) {
			return "Email is already registered";
		}
		customer.setPassword(passwordEncoder.encode(customer.getPassword()));
		customerDAO.save(customer);
		return "User Registartion Successful";
	}
	
	public String existingUserLogin(String email, String password) {    
	    CustomerEntity findCustomer = customerDAO.findByEmail(email);
	    if (findCustomer == null) {
	        return "User with this email doesn't exist";
	    }
	    String storedHashedPassword = findCustomer.getPassword();
	    logger.info("Stored Hashed Password: " + storedHashedPassword);
	    logger.info("Entered Plain Password: " + password);
	    boolean isMatch = passwordEncoder.matches(password, storedHashedPassword);
	    logger.info("Password Match Result: " + isMatch);
	    if (isMatch) {
	        return "User Login Successful";
	    }
	    return "Incorrect Password - Please try again";
	}
	

}
