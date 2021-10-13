package com.rentit.restapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rentit.restapi.entity.Driver;

public interface DriverRepository extends JpaRepository<Driver, Integer> {

}
