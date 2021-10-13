package com.rentit.restapi.restcontroller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rentit.restapi.entity.Trip;
import com.rentit.restapi.service.TripService;

@RestController
@RequestMapping("/api")
public class TripRestController {

	private TripService tripService;

	// inject trip dao
	public TripRestController(TripService theTripService) {
		tripService = theTripService;
	}

	// expose '/trips' and return list of trips
	@GetMapping("/trips")
	public List<Trip> findAll() {
		return tripService.findAll();
	}

	@GetMapping("/trips/{tripId}")
	public Trip getTripById(@PathVariable int tripId) {
		Trip theTrip = tripService.findById(tripId);

		if (theTrip == null)
			throw new RuntimeException("Trip not found");
		return theTrip;
	}

	// mapping to save the new entry

	@PostMapping("/trips")
	public Trip addTrip(@RequestBody Trip theTrip) {
		// for saving a new Trip, we set the id to zero
		theTrip.setId(0);

		tripService.save(theTrip);

		return theTrip;
	}

	// mapping to update the entry

	@PutMapping("/trips")
	public Trip updateTrip(@RequestBody Trip theTrip) {
		tripService.save(theTrip);
		return theTrip;
	}

	// Delete Mapping

	@DeleteMapping("/trips/{tripId}")
	public Trip deleteTrip(@PathVariable int tripId) {
		Trip theTrip = tripService.findById(tripId);

		if (theTrip == null)
			throw new RuntimeException("Trip not found");
		tripService.deleteById(tripId);
		return theTrip;
	}
}
