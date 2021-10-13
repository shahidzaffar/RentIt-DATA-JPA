package com.rentit.restapi.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "vehicle")
public class Vehicle {

	// define fields
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "v_id")
	private int id;

	@Column(name = "v_reg_no")
	private String v_reg_no;

	@Column(name = "model_number")
	private String modelNumber;

	@Column(name = "category")
	private String category;

	@Column(name = "status")
	private boolean status;


	@Column(name = "v_make")
	private String v_make;

	@Column(name = "v_description")
	private String v_description;

	@ManyToOne()
	@JoinColumn(name = "comp_id")
	// @JsonManagedReference
	private Company company;

	@ManyToOne()
	@JoinColumn(name = "t_id")
	// @JsonManagedReference
	private Terminal terminal;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "vehicle", cascade = { CascadeType.ALL })
	@JsonBackReference(value = "feedbackOnVehicle")
	private List<Feedback> feedbacks;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "vehicle", cascade = { CascadeType.ALL })

	@JsonBackReference(value = "tripByVehicle")
	private List<Trip> trips;

	// define constructor

	public Vehicle() {

	}

	public Vehicle(String v_reg_no, String modelNumber, String category, boolean status,
			String v_make, String v_description) {
		super();
		this.v_reg_no = v_reg_no;
		this.modelNumber = modelNumber;
		this.category = category;
		this.status = status;
		this.v_make = v_make;
		this.v_description = v_description;
	}

	// define getter setter

	public String getV_reg_no() {
		return v_reg_no;
	}

	public List<Trip> getTrips() {
		return trips;
	}

	public void setTrips(List<Trip> trips) {
		this.trips = trips;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Feedback> getFeedbacks() {
		return feedbacks;
	}

	public void setFeedbacks(List<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}

	public void setV_reg_no(String v_reg_no) {
		this.v_reg_no = v_reg_no;
	}

	public String getModelNumber() {
		return modelNumber;
	}

	public void setModelNumber(String modelNumber) {
		this.modelNumber = modelNumber;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getV_make() {
		return v_make;
	}

	public void setV_make(String v_make) {
		this.v_make = v_make;
	}

	public String getV_description() {
		return v_description;
	}

	public void setV_description(String v_description) {
		this.v_description = v_description;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Terminal getTerminal() {
		return terminal;
	}

	public void setTerminal(Terminal terminal) {
		this.terminal = terminal;
	}

	// define toString



	public void add(Feedback theFeedback) {
		if (feedbacks == null)
			feedbacks = new ArrayList<Feedback>();
		feedbacks.add(theFeedback);
		theFeedback.setVehicle(this);
	}

	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", v_reg_no=" + v_reg_no + ", modelNumber=" + modelNumber + ", category="
				+ category + ", status=" + status + ", v_make=" + v_make + ", v_description=" + v_description + "]";
	}

	public void add(Trip thetrip) {
		if (trips == null)
			trips = new ArrayList<Trip>();
		trips.add(thetrip);
		thetrip.setVehicle(this);
	}

}
