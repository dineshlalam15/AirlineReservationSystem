package com.project.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.bean.AirlineBean;
import com.project.bean.FlightBean;
import com.project.dao.AirlineDAO;
import com.project.dao.FlightDAO;
import com.project.entity.AirlineEntity;
import com.project.entity.FlightEntity;

@Service
public class AirlineService {

	public static final Logger logger = LoggerFactory.getLogger(AirlineService.class);
	
	@Autowired
	private AirlineDAO airlineDAO;
	
	@Autowired
	private FlightDAO flightDAO;
	
	public List<AirlineBean> getAllAirlines() {
		List<AirlineBean> airlines = new ArrayList<>();
		List<AirlineEntity> airlineEntities = airlineDAO.findAll();
		if(!airlineEntities.isEmpty()) {
			for(AirlineEntity element: airlineEntities) {
				AirlineBean ab = new AirlineBean();
				BeanUtils.copyProperties(element, ab);
				airlines.add(ab);
			}
		}
		return airlines;
	}
	
	public List<FlightBean> getAllFlights(String airline){
		List<FlightBean> flights = new ArrayList<>();
		List<FlightEntity> flightEntities = flightDAO.findByAirline(airline);
		if(!flightEntities.isEmpty()) {
			for(FlightEntity element: flightEntities) {
				FlightBean fb = new FlightBean();
				BeanUtils.copyProperties(element, fb);
				flights.add(fb);
			}
		}
		return flights;
	}

	public FlightBean getFlightByID(String airline, Integer id) {
		FlightBean fb = new FlightBean();
		Optional<AirlineEntity> findAirline = airlineDAO.findByName(airline);
		if(!findAirline.isPresent()) {
			logger.info("Airline " +airline+ " is not registered");
			return null;
		}
		Optional<FlightEntity> flightEntity = flightDAO.findByIDAndAirline(id, airline);
		if(flightEntity.isPresent()) {
			BeanUtils.copyProperties(flightEntity, fb);
		} 
		return fb;
	}

	public FlightBean getFlightByName(String airline, String name) {
		FlightBean fb = new FlightBean();
		Optional<AirlineEntity> findAirline = airlineDAO.findByName(airline);
		if(!findAirline.isPresent()) {
			logger.info("Airline " +airline+ " is not registered");
			return null;
		}
		Optional<FlightEntity> flightEntity = flightDAO.findByNameAndAirline(name, findAirline.get());
		if(flightEntity.isPresent()) {
			BeanUtils.copyProperties(flightEntity, fb);
		} 
		return fb;
	}
	
	public String newFlightRegistration(String airlineName, FlightEntity flight) {
		Optional<AirlineEntity> findAirline = airlineDAO.findByName(airlineName);
		if(!findAirline.isPresent()) {
			return "" + airlineName +  " is not present";
		}
		AirlineEntity airline = findAirline.get();
		String name = flight.getName();
		if(flightDAO.findByNameAndAirline(name, airline).isPresent()) {
			return "Flight " +name+ " is already present in " +airline.getName()+ " airlines";
		}
		airline.getFlights().add(flight);
		flightDAO.save(flight);
		airlineDAO.save(airline);
		return "Flight " +name+ " registered under " +airline.getName() + " airlines";
		
	}

}
