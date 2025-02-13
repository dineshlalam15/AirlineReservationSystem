package com.project.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.bean.CustomerBean;
import com.project.dao.CustomerDAO;
import com.project.entity.CustomerEntity;

@Service
public class CustomerService {
	
	public static final Logger logger = org.slf4j.LoggerFactory.getLogger(CustomerService.class);
	
	@Autowired
	private CustomerDAO customerDAO;
	
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
		if(entity.isPresent()) {
			CustomerEntity customer = entity.get();
			BeanUtils.copyProperties(customer, cb);
		}
		return cb;
	}
}
