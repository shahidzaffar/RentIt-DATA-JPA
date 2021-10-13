package com.rentit.restapi.service;

import java.util.List;

import com.rentit.restapi.entity.Driver;

public interface DriverService {
	public List<Driver> findAll();

	public Driver findById(int id);

	public void save(Driver theDriver);

	public void deleteById(int id);

}
