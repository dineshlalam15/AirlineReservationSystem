package com.project.bean;

import java.time.LocalTime;

public class FlightBean {
	private Integer flightId;
	private String name;
	private AirlineBean airline;
	private String source;
	private String destination;
	private LocalTime departure;
	private LocalTime arrival;
	private Integer totalSeats;
	private Integer bookedSeats;
	
//	Constructors:
	public FlightBean() {
		super();
	}
	
	public FlightBean(Integer flightId, String name, AirlineBean airline, String source, String destination, LocalTime departure, LocalTime arrival,
			Integer totalSeats, Integer bookedSeats) {
		super();
		this.flightId = flightId;
		this.name = name;
		this.airline = airline;
		this.source = source;
		this.destination = destination;
		this.departure = departure;
		this.arrival = arrival;
		this.totalSeats = totalSeats;
		this.bookedSeats = bookedSeats;
	}
	
//	Getters & Setters:
	public Integer getId() {
		return flightId;
	}
	public void setId(Integer flightId) {
		this.flightId = flightId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public AirlineBean getAirline() {
		return airline;
	}

	public void setAirline(AirlineBean airline) {
		this.airline = airline;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public LocalTime getDeparture() {
		return departure;
	}
	public void setDeparture(LocalTime departure) {
		this.departure = departure;
	}
	public LocalTime getArrival() {
		return arrival;
	}
	public void setArrival(LocalTime arrival) {
		this.arrival = arrival;
	}
	public Integer getTotalSeats() {
		return totalSeats;
	}
	public void setTotalSeats(Integer totalSeats) {
		this.totalSeats = totalSeats;
	}
	public Integer getBookedSeats() {
		return bookedSeats;
	}
	public void setBookedSeats(Integer bookedSeats) {
		this.bookedSeats = bookedSeats;
	}

	@Override
	public String toString() {
		return "FlightBean [flightId=" + flightId + ", name=" + name + ", airline=" + airline + ", source=" + source
				+ ", destination=" + destination + ", departure=" + departure + ", arrival=" + arrival + ", totalSeats="
				+ totalSeats + ", bookedSeats=" + bookedSeats + "]";
	}
}
