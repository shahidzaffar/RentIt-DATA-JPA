package com.rentit.restapi.service;

import java.util.List;

import com.rentit.restapi.entity.Customer;

public interface CustomerService {
	public List<Customer> findAll();

	public Customer findById(int id);

	public void save(Customer theCustomer);

	public void deleteById(int id);

}
