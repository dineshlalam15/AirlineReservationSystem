package com.project.bean;

import java.util.List;
import java.util.Objects;

public class AirlineBean {
	private Integer airlineID;
	private String name;
	private Integer noOfFlights;
	private List<FlightBean> flights;
	
//	Constructors:
	public AirlineBean(Integer airlineID, String name, Integer noOfFlights, List<FlightBean> flights) {
		super();
		this.airlineID = airlineID;
		this.name = name;
		this.noOfFlights = noOfFlights;
		this.flights = flights;
	}
	
	public AirlineBean() {
		super();
	}
	
	public AirlineBean(List<FlightBean> flights) {
		super();
		this.flights = flights;
	}
	
//	Getters and Setters:
	public Integer getAirlineID() {
		return airlineID;
	}
	public void setAirlineID(Integer airlineID) {
		this.airlineID = airlineID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getNoOfFlights() {
		return noOfFlights;
	}
	public void setNoOfFlights(Integer noOfFlights) {
		this.noOfFlights = noOfFlights;
	}
	public List<FlightBean> getFlights() {
		return flights;
	}
	public void setFlights(List<FlightBean> flights) {
		this.flights = flights;
	}

	@Override
	public int hashCode() {
		return Objects.hash(airlineID, flights, name, noOfFlights);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AirlineBean other = (AirlineBean) obj;
		return Objects.equals(airlineID, other.airlineID) && Objects.equals(flights, other.flights)
				&& Objects.equals(name, other.name) && Objects.equals(noOfFlights, other.noOfFlights);
	}

	@Override
	public String toString() {
		return "AirlineBean [airlineID=" + airlineID + ", name=" + name + ", noOfFlights=" + noOfFlights + ", flights="
				+ flights + "]";
	}
	
}
