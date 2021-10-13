package com.rentit.restapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rentit.restapi.dao.DriverRepository;
import com.rentit.restapi.entity.Driver;

@Service
public class DriverServiceImplimentation implements DriverService {

	private DriverRepository driverRepository;

	@Autowired
	public DriverServiceImplimentation(DriverRepository theDriverRepository) {
		driverRepository = theDriverRepository;
	}

	@Override

	public List<Driver> findAll() {

		return driverRepository.findAll();
	}

	@Override
	public Driver findById(int id) {

		Optional<Driver> result = driverRepository.findById(id);

		Driver theDriver = null;
		if (result.isPresent()) {
			theDriver = result.get();
		} else
			throw new RuntimeException("Driver not found");

		return theDriver;

	}

	@Override
	public void save(Driver theDriver) {

		driverRepository.save(theDriver);

	}

	@Override
	public void deleteById(int id) {
		driverRepository.deleteById(id);

	}

}
