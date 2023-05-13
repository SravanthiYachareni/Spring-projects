package com.nareshit.ticketbooking.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 *
 * This class is Model Class ..It will create a database table automatically
 * @Entity ==> POJO Class will be converted to database object
 *         ==> By default table name will className
 *
 * @Table  ==> Customize the table name. Its an optional annotation
 *
 * By default Every Java Property is table column
 *
 * As per JPA ==> Primary Key is mandatory and as per databse ==> Its optional
 *
 * @GeneratedValue==>Framework automatically generates this value and its not userinput
 *
 * AUTO ==> JPA will create a database sequence and it will increment (max(id)+1) and adds this value
 *           to insert statement
 */


@Entity
@Table(name = "tbl_ticket")
public class Ticket {


	@Id //Primary Key
	@Column(name = "ticket_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer ticketId;

	@Column(name = "passenger_name")
	private String passengerName;



	@Column(name = "source_station")
	private String sourceStation;

	@Column(name = "destination_station")
	private String destinationStation;


	private String email;

	@Column(name = "travel_date")
	private Date travelDate;

	public Integer getTicketId() {
		return ticketId;
	}

	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public String getSourceStation() {
		return sourceStation;
	}

	public void setSourceStation(String sourceStation) {
		this.sourceStation = sourceStation;
	}

	public String getDestinationStation() {
		return destinationStation;
	}

	public void setDestinationStation(String destinationStation) {
		this.destinationStation = destinationStation;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getTravelDate() {
		return travelDate;
	}

	public void setTravelDate(Date travelDate) {
		this.travelDate = travelDate;
	}

	public Ticket(String passengerName, String sourceStation, String destinationStation, String email) {
		super();
		this.passengerName = passengerName;
		this.sourceStation = sourceStation;
		this.destinationStation = destinationStation;
		this.email = email;
		this.travelDate = new Date();
	}

	public Ticket() {}

	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", passengerName=" + passengerName + ", sourceStation=" + sourceStation
				+ ", destinationStation=" + destinationStation + ", email=" + email + ", travelDate=" + travelDate
				+ "]";
	}







}
