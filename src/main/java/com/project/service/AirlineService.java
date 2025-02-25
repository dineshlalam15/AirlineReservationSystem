package com.project.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.bean.AirlineBean;
import com.project.dao.AirlineDAO;
import com.project.entity.AirlineEntity;

@Service
public class AirlineService {

	public static final Logger logger = LoggerFactory.getLogger(AirlineService.class);
	
	@Autowired
	private AirlineDAO airlineDAO;
	
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

}
