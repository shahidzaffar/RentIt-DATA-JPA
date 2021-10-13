package com.rentit.restapi.service;

import java.util.List;

import com.rentit.restapi.entity.Payment;

public interface PaymentService {
	public List<Payment> findAll();

	public Payment findById(int id);

	public void save(Payment thePayment);

	public void deleteById(int id);

}
