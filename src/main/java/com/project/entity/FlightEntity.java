package com.project.entity;

import java.time.LocalTime;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name="flights")
public class FlightEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="flight_id")
	private Integer flightId;
	@Column(name="flight_name", nullable=false, unique=true)
	private String name;
	@ManyToOne
    @JoinColumn(name = "airline_id", nullable = false)
	private AirlineEntity airline;
	@Column(nullable = false)
	private String source;
	@Column(nullable = false)
	private String destination;
	@Column(name="departure_time", nullable = false)
	private LocalTime departure;
	@Column(name="arrival_time", nullable = false)
	private LocalTime arrival;
	@Column(name="total_seats", nullable = false)
	private Integer totalSeats;
	@Column(name="booked_seats", nullable = false)
	private Integer bookedSeats;
	
	@Transient
	public Integer getRemainingSeats() {
		return totalSeats - bookedSeats;
	}

	// Constructors
	public FlightEntity() {
		
	}

	public FlightEntity(Integer flightId, String name, AirlineEntity airline, String source, String destination,
						LocalTime departure, LocalTime arrival, Integer totalSeats, Integer bookedSeats) {
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

	// Getters & Setters
	public Integer getFlightId() {
		return flightId;
	}
	public void setFlightId(Integer flightId) {
		this.flightId = flightId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public AirlineEntity getAirline() {
		return airline;
	}
	public void setAirline(AirlineEntity airline) {
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

	@PrePersist
	@PreUpdate
	private void validateSeats() throws Exception {
		if (bookedSeats > totalSeats) {
			throw new Exception("Booked seats cannot exceed total seats.");
		}
	}

	@Override
	public String toString() {
		return "FlightEntity [flightId=" + flightId + ", name=" + name + ", airline=" + airline + ", source=" + source
				+ ", destination=" + destination + ", departure=" + departure + ", arrival=" + arrival + ", totalSeats="
				+ totalSeats + ", bookedSeats=" + bookedSeats + ", remainingSeats=" + getRemainingSeats() + "]";
	}

	@JsonIgnore
	@Override
	public int hashCode() {
		return Objects.hash(airline, arrival, bookedSeats, departure, destination, flightId, name, source, totalSeats);
	}

	@JsonIgnore
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		FlightEntity other = (FlightEntity) obj;
		return Objects.equals(flightId, other.flightId) && Objects.equals(name, other.name)
				&& Objects.equals(airline, other.airline) && Objects.equals(source, other.source)
				&& Objects.equals(destination, other.destination) && Objects.equals(departure, other.departure)
				&& Objects.equals(arrival, other.arrival) && Objects.equals(totalSeats, other.totalSeats)
				&& Objects.equals(bookedSeats, other.bookedSeats);
	}
}
