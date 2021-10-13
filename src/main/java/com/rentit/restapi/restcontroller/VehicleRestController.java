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
import com.rentit.restapi.entity.Vehicle;
import com.rentit.restapi.service.VehicleService;

@RestController
@RequestMapping("/api")
public class VehicleRestController {

	private VehicleService vehicleService;

	// inject vehicle dao
	public VehicleRestController(VehicleService theVehicleService) {
		vehicleService = theVehicleService;
	}

	// expose '/vehicles' and return list of vehicles
	@GetMapping("/vehicles")
	public List<Vehicle> findAll() {
		return vehicleService.findAll();
	}

	@GetMapping("/vehicles/{vehicleId}")
	public Vehicle getVehicleById(@PathVariable int vehicleId) {
		Vehicle theVehicle = vehicleService.findById(vehicleId);

		if (theVehicle == null)
			throw new RuntimeException("Vehicle not found");
		return theVehicle;
	}

	@PostMapping("/vehicles")
	public Vehicle addVehicle(@RequestBody Vehicle theVehicle) {

		vehicleService.save(theVehicle);

		return theVehicle;
	}

	// mapping to update the entry

	@PutMapping("/vehicles")
	public Vehicle updateVehicle(@RequestBody Vehicle theVehicle) {
		vehicleService.save(theVehicle);
		return theVehicle;
	}

	@DeleteMapping("/vehicles/{vehicleId}")
	public Vehicle deleteVehicle(@PathVariable int vehicleId) {
		Vehicle theVehicle = vehicleService.findById(vehicleId);

		if (theVehicle == null)
			throw new RuntimeException("Vehicle not found");
		vehicleService.deleteById(vehicleId);
		return theVehicle;
	}
}
