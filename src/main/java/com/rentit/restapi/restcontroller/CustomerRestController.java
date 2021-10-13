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

import com.rentit.restapi.entity.Customer;
import com.rentit.restapi.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

	private CustomerService customerService;

	// inject customer dao
	public CustomerRestController(CustomerService theCustomerService) {
		customerService = theCustomerService;
	}

	// expose '/customers' and return list of customers
	@GetMapping("/customers")
	public List<Customer> findAll() {
		return customerService.findAll();
	}

	@GetMapping("/customers/{customerId}")
	public Customer getCustomerById(@PathVariable int customerId) {
		Customer theCustomer = customerService.findById(customerId);

		if (theCustomer == null)
			throw new RuntimeException("Customer not found");
		return theCustomer;
	}

	// mapping to save the new entry

	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer theCustomer) {
		// for saving a new Customer, we set the id to zero
		theCustomer.setId(0);

		customerService.save(theCustomer);

		return theCustomer;
	}

	// mapping to update the entry

	@PutMapping("/customers")
	public Customer updateCustomer(@RequestBody Customer theCustomer) {
		customerService.save(theCustomer);
		return theCustomer;
	}

	@DeleteMapping("/customers/{customerId}")
	public Customer deleteCustomer(@PathVariable int customerId) {
		Customer theCustomer = customerService.findById(customerId);

		if (theCustomer == null)
			throw new RuntimeException("Customer not found");
		customerService.deleteById(customerId);
		return theCustomer;
	}

}
