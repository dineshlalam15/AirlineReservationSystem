package com.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.entity.AirlineEntity;

@Repository
public interface AirlineDAO extends JpaRepository<AirlineEntity, String>{

}

