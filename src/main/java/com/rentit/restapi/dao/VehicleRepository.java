package com.rentit.restapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rentit.restapi.entity.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {

}
