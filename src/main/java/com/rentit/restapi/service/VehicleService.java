package com.rentit.restapi.service;

import java.util.List;

import com.rentit.restapi.entity.Vehicle;

public interface VehicleService {
	public List<Vehicle> findAll();

	public Vehicle findById(int vehRegNo);

	public void save(Vehicle theVehicle);

	public void deleteById(int vehRegNo);

}
