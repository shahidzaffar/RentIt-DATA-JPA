package com.rentit.restapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rentit.restapi.entity.Trip;

public interface TripRepository extends JpaRepository<Trip, Integer> {

}
