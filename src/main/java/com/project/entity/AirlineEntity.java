package com.project.entity;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="airlines")
public class AirlineEntity {
	@Id
	@Column(name="airline_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer airlineId;
	@Column(name="airline_name", nullable = false, unique=true)
	private String name;
	@Column(name="no_of_flights", nullable=false)
	private Integer noOfFlights;
	@Column(nullable=false)
	@ElementCollection
	@OneToMany(mappedBy = "airline", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<FlightEntity> flights;
	
//	Constructors:
	public AirlineEntity(Integer airlineId, String name, Integer noOfFlights, List<FlightEntity> flights) {
		super();
		this.airlineId = airlineId;
		this.name = name;
		this.noOfFlights = noOfFlights;
		this.flights = flights;
	}
	
	public AirlineEntity() {
		super();
	}
	
//	Getters & Setters:
	public Integer getAirlineId() {
		return airlineId;
	}
	public void setAirlineId(Integer airlineId) {
		this.airlineId = airlineId;
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
	public List<FlightEntity> getFlights() {
		return flights;
	}
	public void setFlights(List<FlightEntity> flights) {
		this.flights = flights;
	}
	
	@Override
	public String toString() {
		return "AirlineEntity [airlineId=" + airlineId + ", name=" + name + ", noOfFlights=" + noOfFlights
				+ ", flights=" + flights + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(airlineId, flights, name, noOfFlights);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AirlineEntity other = (AirlineEntity) obj;
		return Objects.equals(airlineId, other.airlineId) && Objects.equals(flights, other.flights)
				&& Objects.equals(name, other.name) && Objects.equals(noOfFlights, other.noOfFlights);
	}
	
}
