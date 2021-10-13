//package com.rentit.restapi.entity;
//
//import java.sql.Date;
//import java.sql.Time;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.OneToOne;
//import javax.persistence.Table;
//
//import com.fasterxml.jackson.annotation.JsonBackReference;
//
//@Entity
//@Table(name = "trip")
//public class Trip {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "trip_id")
//	private int id;
//
//	@Column(name = "trip_date")
//	private Date trip_date;
//
//	@Column(name = "start_time")
//	private Time start_time;
//
//	@Column(name = "end_time")
//	private Time end_time;
//
//	@Column(name = "meter_reading_at_start")
//	private double reading_at_start;
//
//	@Column(name = "meter_reading_at_end")
//	private double reading_at_end;
//
//	@Column(name = "trip_descrption")
//	private String description;
//
//	@ManyToOne
//	@JoinColumn(name = "v_id")
//	// @JsonManagedReference
//	private Vehicle vehicle;
//
//	@ManyToOne
//	@JoinColumn(name = "driver_id")
//	// @JsonManagedReference
//	private Driver driver;
//
//	@ManyToOne
//	@JoinColumn(name = "cus_id")
//	// @JsonManagedReference
//	private Customer customer;
//
//	@OneToOne(fetch = FetchType.LAZY, mappedBy = "trip", cascade = CascadeType.ALL)
//	@JsonBackReference(value = "paymentOfTrip")
//	private Payment payment;
//
//	// define constructor
//
//	public Trip() {
//
//	}
//
//	public Trip(Date trip_date, Time start_time, Time end_time, double reading_at_start, double reading_at_end,
//			String description) {
//		super();
//		this.trip_date = trip_date;
//		this.start_time = start_time;
//		this.end_time = end_time;
//		this.reading_at_start = reading_at_start;
//		this.reading_at_end = reading_at_end;
//		this.description = description;
//	}
//
//	// define getter setter
//
//	public int getId() {
//		return id;
//	}
//
//	public Payment getPayment() {
//		return payment;
//	}
//
//	public void setPayment(Payment payment) {
//		this.payment = payment;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public Date getTrip_date() {
//		return trip_date;
//	}
//
//	public void setTrip_date(Date trip_date) {
//		this.trip_date = trip_date;
//	}
//
//	public Time getStart_time() {
//		return start_time;
//	}
//
//	public void setStart_time(Time start_time) {
//		this.start_time = start_time;
//	}
//
//	public Time getEnd_time() {
//		return end_time;
//	}
//
//	public void setEnd_time(Time end_time) {
//		this.end_time = end_time;
//	}
//
//	public double getReading_at_start() {
//		return reading_at_start;
//	}
//
//	public void setReading_at_start(double reading_at_start) {
//		this.reading_at_start = reading_at_start;
//	}
//
//	public double getReading_at_end() {
//		return reading_at_end;
//	}
//
//	public void setReading_at_end(double reading_at_end) {
//		this.reading_at_end = reading_at_end;
//	}
//
//	public String getDescription() {
//		return description;
//	}
//
//	public void setDescription(String description) {
//		this.description = description;
//	}
//
//	public Vehicle getVehicle() {
//		return vehicle;
//	}
//
//	public void setVehicle(Vehicle vehicle) {
//		this.vehicle = vehicle;
//	}
//
//	public Driver getDriver() {
//		return driver;
//	}
//
//	public void setDriver(Driver driver) {
//		this.driver = driver;
//	}
//
//	public Customer getCustomer() {
//		return customer;
//	}
//
//	public void setCustomer(Customer customer) {
//		this.customer = customer;
//	}
//
//	// define toString
//
//	@Override
//	public String toString() {
//		return "Trip [id=" + id + ", trip_date=" + trip_date + ", start_time=" + start_time + ", end_time=" + end_time
//				+ ", reading_at_start=" + reading_at_start + ", reading_at_end=" + reading_at_end + ", description="
//				+ description + ", vehicle=" + vehicle + ", driver=" + driver + ", customer=" + customer + "]";
//	}
//
//}


package com.rentit.restapi.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "trip")
public class Trip {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "trip_id")
	private int id;

	@Column(name = "trip_date")
	private String trip_date;

	@Column(name = "start_time")
	private String start_time;

	@Column(name = "end_time")
	private String end_time;

	@Column(name = "meter_reading_at_start")
	private double reading_at_start;

	@Column(name = "meter_reading_at_end")
	private double reading_at_end;

	@Column(name = "trip_descrption")
	private String description;
	
	@Column(name="status")
	private String status;

	
	@Column(name="isdriver")
	private boolean optionDriver;
	
	
	@ManyToOne
	@JoinColumn(name = "v_id")
	// @JsonManagedReference
	private Vehicle vehicle;

	@ManyToOne
	@JoinColumn(name = "driver_id")
	// @JsonManagedReference
	private Driver driver;

	@ManyToOne
	@JoinColumn(name = "cus_id")
	// @JsonManagedReference
	private Customer customer;
	
	
	@ManyToOne
	@JoinColumn(name = "t_id")
	// @JsonManagedReference
	private Terminal terminal;

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "trip")
	@JsonBackReference(value = "paymentOfTrip")
	private Payment payment;

	// define constructor

	public Trip() {

	}

	public Trip(String trip_date, String start_time, String end_time, double reading_at_start, double reading_at_end,
			String description, String status, boolean isdriver) {
		super();
		this.trip_date = trip_date;
		this.start_time = start_time;
		this.end_time = end_time;
		this.reading_at_start = reading_at_start;
		this.reading_at_end = reading_at_end;
		this.description = description;
		this.status=status;
		this.optionDriver=isdriver;
	}

	// define getter setter

	public int getId() {
		return id;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTrip_date() {
		return trip_date;
	}

	public void setTrip_date(String trip_date) {
		this.trip_date = trip_date;
	}

	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public String getEnd_time() {
		return end_time;
	}

	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}

	public boolean isOptionDriver() {
		return optionDriver;
	}

	public void setOptionDriver(boolean optionDriver) {
		this.optionDriver = optionDriver;
	}

	public double getReading_at_start() {
		return reading_at_start;
	}

	public void setReading_at_start(double reading_at_start) {
		this.reading_at_start = reading_at_start;
	}
	

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getReading_at_end() {
		return reading_at_end;
	}

	public void setReading_at_end(double reading_at_end) {
		this.reading_at_end = reading_at_end;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	public Terminal getTerminal() {
		return terminal;
	}

	public void setTerminal(Terminal terminal) {
		this.terminal = terminal;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Trip [id=" + id + ", trip_date=" + trip_date + ", start_time=" + start_time + ", end_time=" + end_time
				+ ", reading_at_start=" + reading_at_start + ", reading_at_end=" + reading_at_end + ", description="
				+ description + ", status=" + status +  ", isDriver=" + optionDriver + "]";
	}

	// define toString

	

}

