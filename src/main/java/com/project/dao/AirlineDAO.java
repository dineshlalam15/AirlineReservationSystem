package com.project.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.entity.AirlineEntity;

@Repository
public interface AirlineDAO extends JpaRepository<AirlineEntity, Integer>{
	boolean existsByName(String name);
	Optional<AirlineEntity> findByName(String name);
}

