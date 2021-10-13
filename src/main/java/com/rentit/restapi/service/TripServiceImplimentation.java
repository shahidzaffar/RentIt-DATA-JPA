package com.rentit.restapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rentit.restapi.dao.TripRepository;
import com.rentit.restapi.entity.Trip;

@Service
public class TripServiceImplimentation implements TripService {

	private TripRepository tripRepository;

	// @PersistenceContext
	// private EntityManager entityManager;

	@Autowired
	public TripServiceImplimentation(TripRepository theTripRepository) {
		tripRepository = theTripRepository;
	}

	@Override

	public List<Trip> findAll() {
		return tripRepository.findAll();
	}

	@Override

	public Trip findById(int id) {
		// return tripRepository.findById(id);
		Optional<Trip> result = tripRepository.findById(id);

		Trip theTrip = null;
		if (result.isPresent()) {
			theTrip = result.get();
		} else
			throw new RuntimeException("Trip not found");

		return theTrip;

	}

	@Override

	public void save(Trip theTrip) {
		// Session currentSession = entityManager.unwrap(Session.class);
		//
		// Customer customer=currentSession.get(Customer.class, 1);
		// customer.add(theTrip);
		//
		// //Driver Forign key
		// Driver driver=currentSession.get(Driver.class, 1);
		// driver.add(theTrip);
		//
		// Vehicle vehicle=currentSession.get(Vehicle.class, 2);
		// vehicle.add(theTrip);

		tripRepository.save(theTrip);

	}

	@Override

	public void deleteById(int id) {
		tripRepository.deleteById(id);

	}

}
