package com.rentit.restapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rentit.restapi.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
