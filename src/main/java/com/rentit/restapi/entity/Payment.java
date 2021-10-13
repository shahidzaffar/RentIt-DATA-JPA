package com.rentit.restapi.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "payment")
public class Payment {

	// define fields

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "payment_id")
	private int id;

	@Column(name = "payment_method")
	private String payment_method;

	@Column(name = "bill")
	private double bill;

	@Column(name = "payment_description")
	private String description;

	@ManyToOne()
	@JoinColumn(name = "cus_id")
	// @JsonManagedReference

	private Customer customer;

	@OneToOne()
	@JoinColumn(name = "trip_id")
	// @JsonManagedReference

	private Trip trip;

	// define constructor

	public Payment() {

	}

	public Payment(String payment_me, double bill, String description) {
		super();
		this.payment_method = payment_me;
		this.bill = bill;
		this.description = description;
	}

	// define getter setter

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPayment_method() {
		return payment_method;
	}

	public void setPayment_method(String payment_method) {
		this.payment_method = payment_method;
	}

	public double getBill() {
		return bill;
	}

	public void setBill(double bill) {
		this.bill = bill;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Trip getTrip() {
		return trip;
	}

	public void setTrip(Trip trip) {
		this.trip = trip;
	}

	// define toString

	@Override
	public String toString() {
		return "Payment [id=" + id + ", payment_method=" + payment_method + ", bill=" + bill + ", description="
				+ description + ", customer=" + customer + ", trip=" + trip + "]";
	}

}
