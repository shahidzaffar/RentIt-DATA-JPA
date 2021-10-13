package com.rentit.restapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rentit.restapi.dao.CustomerRepository;
import com.rentit.restapi.entity.Customer;

@Service
public class CustomerServiceImplimentation implements CustomerService {

	private CustomerRepository customerRepository;

	@Autowired
	public CustomerServiceImplimentation(CustomerRepository theCustomerRepository) {
		customerRepository = theCustomerRepository;
	}

	@Override

	public List<Customer> findAll() {
		return customerRepository.findAll();

	}

	@Override

	public Customer findById(int id) {
		Optional<Customer> result = customerRepository.findById(id);

		Customer theCustomer = null;
		if (result.isPresent()) {
			theCustomer = result.get();
		} else
			throw new RuntimeException("Customer not found");

		return theCustomer;

	}

	@Override

	public void save(Customer theCustomer) {
		customerRepository.save(theCustomer);

	}

	@Override

	public void deleteById(int id) {
		customerRepository.deleteById(id);

	}

}
