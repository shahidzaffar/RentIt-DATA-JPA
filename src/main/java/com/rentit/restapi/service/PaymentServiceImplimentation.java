package com.rentit.restapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rentit.restapi.dao.PaymentRepository;
import com.rentit.restapi.entity.Payment;

@Service
public class PaymentServiceImplimentation implements PaymentService {

	private PaymentRepository paymentRepository;

	// @PersistenceContext
	// private EntityManager entityManager;
	//

	@Autowired
	public PaymentServiceImplimentation(PaymentRepository thePaymentRepository) {
		paymentRepository = thePaymentRepository;
	}

	@Override

	public List<Payment> findAll() {

		return paymentRepository.findAll();
	}

	@Override
	public Payment findById(int id) {

		Optional<Payment> result = paymentRepository.findById(id);

		Payment thePayment = null;
		if (result.isPresent()) {
			thePayment = result.get();
		} else
			throw new RuntimeException("Payment not found");

		return thePayment;

	}

	@Override
	public void save(Payment thePayment) {
		// Session currentSession = entityManager.unwrap(Session.class);
		//
		//
		// Customer customer=currentSession.get(Customer.class, 1);
		// customer.add(thePayment);

		paymentRepository.save(thePayment);

	}

	@Override
	public void deleteById(int id) {
		paymentRepository.deleteById(id);

	}

}
