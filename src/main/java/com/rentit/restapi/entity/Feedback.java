package com.rentit.restapi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "feedback")
public class Feedback {

	// define fields
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "feedback_id")
	private int id;

	@Column(name = "feedback_description")
	private String description;

	@Column(name = "rating")
	private double rating;

	@ManyToOne()
	@JoinColumn(name = "cus_id")
	// @JsonManagedReference
	private Customer customer;

	@ManyToOne()
	@JoinColumn(name = "v_id")
	// @JsonManagedReference
	private Vehicle vehicle;

	// define constructor

	public Feedback() {

	}

	public Feedback(String description, double rating) {
		super();
		this.description = description;
		this.rating = rating;
	}

	// define getter setter

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	@Override
	public String toString() {
		return "Feedback [id=" + id + ", description=" + description + ", rating=" + rating + "]";
	}

	// define toString
}
