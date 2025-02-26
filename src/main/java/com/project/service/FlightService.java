package com.project.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.bean.FlightBean;
import com.project.dao.FlightDAO;
import com.project.entity.FlightEntity;

@Service
public class FlightService {
	
	public static final Logger logger = LoggerFactory.getLogger(FlightService.class);
	
	@Autowired
	private FlightDAO flightDAO;
	
	public List<FlightBean> getAllFlights(){
		List<FlightBean> flights = new ArrayList<>();
		List<FlightEntity> flightEntities = flightDAO.findAll();
		if(!flightEntities.isEmpty()) {
			for(FlightEntity element: flightEntities) {
				FlightBean fb = new FlightBean();
				BeanUtils.copyProperties(element, fb);
				flights.add(fb);
			}
		} return flights;
		
	}
}
