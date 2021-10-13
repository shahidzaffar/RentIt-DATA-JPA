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

import com.rentit.restapi.entity.Driver;
import com.rentit.restapi.service.DriverService;

@RestController
@RequestMapping("/api")
public class DriverRestController {

	private DriverService driverService;

	// inject Driver dao
	public DriverRestController(DriverService theDriverService) {
		driverService = theDriverService;
	}

	// expose '/drivers' and return list of drivers
	@GetMapping("/drivers")
	public List<Driver> findAll() {
		return driverService.findAll();
	}

	@GetMapping("/drivers/{driverId}")
	public Driver getDriverById(@PathVariable int driverId) {
		Driver theDriver = driverService.findById(driverId);

		if (theDriver == null)
			throw new RuntimeException("Driver not found");
		return theDriver;
	}

	// mapping to save the new entry

	@PostMapping("/drivers")
	public Driver addDriver(@RequestBody Driver theDriver) {
		// for saving a new Admin, we set the id to zero
		theDriver.setId(0);
		driverService.save(theDriver);
		return theDriver;
	}

	// mapping to update the entry

	@PutMapping("/drivers")
	public Driver updateDriver(@RequestBody Driver theDriver) {
		driverService.save(theDriver);
		return theDriver;
	}

	// Delete a driver mapping

	@DeleteMapping("/drivers/{driverId}")
	public Driver deleteDriver(@PathVariable int driverId) {
		Driver theDriver = driverService.findById(driverId);

		if (theDriver == null)
			throw new RuntimeException("Driver not found");
		driverService.deleteById(driverId);
		return theDriver;
	}

}
