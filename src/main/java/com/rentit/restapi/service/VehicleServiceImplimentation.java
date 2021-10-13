package com.rentit.restapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rentit.restapi.dao.VehicleRepository;
import com.rentit.restapi.entity.Vehicle;

@Service
public class VehicleServiceImplimentation implements VehicleService {

	private VehicleRepository vehicleRepository;

	// @PersistenceContext
	// private EntityManager entityManager;

	@Autowired
	public VehicleServiceImplimentation(VehicleRepository theVehicleRepository) {
		vehicleRepository = theVehicleRepository;
	}

	@Override

	public List<Vehicle> findAll() {

		return vehicleRepository.findAll();
	}

	@Override
	public Vehicle findById(int vehRegNo) {

		// return vehicleRepository.findById(vehRegNo);
		Optional<Vehicle> result = vehicleRepository.findById(vehRegNo);

		Vehicle theVehicle = null;
		if (result.isPresent()) {
			theVehicle = result.get();
		} else
			throw new RuntimeException("Vehicle not found");

		return theVehicle;

	}

	@Override
	public void save(Vehicle theVehicle) {
		// Session currentSession = entityManager.unwrap(Session.class);
		//
		// Company company=currentSession.get(Company.class,2);
		//
		// company.add(theVehicle);
		//
		// Terminal terminal=currentSession.get(Terminal.class,1);
		//
		// terminal.add(theVehicle);
		vehicleRepository.save(theVehicle);

	}

	@Override

	public void deleteById(int vehRegNo) {
		vehicleRepository.deleteById(vehRegNo);

	}

}
