package com.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.entity.CustomerEntity;

@Repository
public interface CustomerDAO extends JpaRepository<CustomerEntity, String>{
	boolean existsByEmail(String email);
	CustomerEntity findByEmail(String email);
}
