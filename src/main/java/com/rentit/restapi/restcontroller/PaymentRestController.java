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
import com.rentit.restapi.entity.Payment;
import com.rentit.restapi.service.PaymentService;

@RestController
@RequestMapping("/api")
public class PaymentRestController {

	private PaymentService paymentService;

	// inject Payment dao
	public PaymentRestController(PaymentService thePaymentService) {
		paymentService = thePaymentService;
	}

	// expose '/payments' and return list of Payments
	@GetMapping("/payments")
	public List<Payment> findAll() {
		return paymentService.findAll();
	}

	@GetMapping("/payments/{paymentId}")
	public Payment getPaymentById(@PathVariable int paymentId) {
		Payment thePayment = paymentService.findById(paymentId);

		if (thePayment == null)
			throw new RuntimeException("Payment not found");
		return thePayment;
	}

	// mapping to save the new entry

	@PostMapping("/payments")
	public Payment addPayment(@RequestBody Payment thePayment) {
		// for saving a new Admin, we set the id to zero
		thePayment.setId(0);

		paymentService.save(thePayment);

		return thePayment;
	}

	// mapping to update the entry

	@PutMapping("/payments")
	public Payment updatePayment(@RequestBody Payment thePayment) {
		paymentService.save(thePayment);
		return thePayment;
	}

	// Delete mapping

	@DeleteMapping("/payments/{paymentId}")
	public Payment deletePayment(@PathVariable int paymentId) {
		Payment thePayment = paymentService.findById(paymentId);

		if (thePayment == null)
			throw new RuntimeException("Payment not found");
		paymentService.deleteById(paymentId);
		return thePayment;
	}

}
