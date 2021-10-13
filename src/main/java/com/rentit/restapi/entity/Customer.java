package com.rentit.restapi.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "customer")
public class Customer {

	// define fields

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cus_id")
	private int id;

	@Column(name = "cus_name")
	private String name;

	@Column(name = "cus_username")
	private String userName;

	@Column(name = "cus_password")
	private String password;

	@Column(name = "cus_email")
	private String email;

	@Column(name = "cus_cnic")
	private String cnic;

	@Column(name = "cus_mobile_number")
	private String phone;

	@Column(name = "cus_description")
	private String description;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customer", cascade = {CascadeType.ALL })
	@JsonBackReference(value = "feedbacksByCustomer")

	private List<Feedback> feedback;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customer", cascade = { CascadeType.ALL })
	@JsonBackReference(value = "tripByCustomer")
	private List<Trip> trip;
	
	

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customer", cascade = { CascadeType.ALL })
	@JsonBackReference(value = "payment")

	private List<Payment> payment;

	// define constructor

	public Customer() {

	}

	public Customer(String name, String userName, String password, String email, String cnic, String phone,
			String description) {
		super();
		this.name = name;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.cnic = cnic;
		this.phone = phone;
		this.description = description;
	}

	// define Getters Setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCnic() {
		return cnic;
	}

	public void setCnic(String cnic) {
		this.cnic = cnic;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Feedback> getFeedback() {
		return feedback;
	}

	public void setFeedback(List<Feedback> feedback) {
		this.feedback = feedback;
	}

	public List<Trip> getTrip() {
		return trip;
	}

	public void setTrip(List<Trip> trip) {
		this.trip = trip;
	}

	public List<Payment> getPayment() {
		return payment;
	}

	public void setPayment(List<Payment> payment) {
		this.payment = payment;
	}

	// define toString

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", userName=" + userName + ", password=" + password
				+ ", email=" + email + ", cnic=" + cnic + ", phone=" + phone + ", description=" + description + "]";
	}

}
