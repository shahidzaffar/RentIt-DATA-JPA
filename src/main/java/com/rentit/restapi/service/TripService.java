package com.rentit.restapi.service;

import java.util.List;

import com.rentit.restapi.entity.Trip;

public interface TripService {
	public List<Trip> findAll();

	public Trip findById(int id);

	public void save(Trip theTrip);

	public void deleteById(int id);

}
