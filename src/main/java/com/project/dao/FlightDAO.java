package com.project.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.entity.AirlineEntity;
import com.project.entity.FlightEntity;

@Repository
public interface FlightDAO extends JpaRepository<FlightEntity, Integer> {
	Optional<FlightEntity> findByNameAndAirline(String name, AirlineEntity airline);
	List<FlightEntity> findByAirline(String airline);
	Optional<FlightEntity> findByIDAndAirline(Integer id, String airline);
}
