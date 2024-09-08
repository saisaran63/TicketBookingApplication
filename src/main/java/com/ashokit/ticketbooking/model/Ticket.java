package com.ashokit.ticketbooking.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity //This class will be creating a table to datbase with classname as tablename
@Table(name = "tbl_ticket") //This will rename the table with tbl_ticket
public class Ticket {
	
	@Id//This will create primary key o the ticketId Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	//JPA will create a sequence to the datbase and it use this while inserting the data
	@Column(name = "ticket_id")
	private Integer ticketId;
	
	//By default Column Name=property Name
	@Column(name="passenger_name") 
	//This will rename the classname with passenger_name
	private String passengerName;
	
	
	@Column(name = "source_station")
	private String sourceStation;
	
	@Column(name = "destination_station")
	private String destinationStation;
	
	@Column(name = "travel_date")
	private Date travelDate;
	
	private String email;

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

	public Date getTravelDate() {
		return travelDate;
	}

	public void setTravelDate(Date travelDate) {
		this.travelDate = travelDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Ticket( String passengerName, String sourceStation, String destinationStation,
			Date travelDate, String email) {
		super();
		
		this.passengerName = passengerName;
		this.sourceStation = sourceStation;
		this.destinationStation = destinationStation;
		this.travelDate = travelDate;
		this.email = email;
	}
	public Ticket( ) {}

	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", passengerName=" + passengerName + ", sourceStation=" + sourceStation
				+ ", destinationStation=" + destinationStation + ", travelDate=" + travelDate + ", email=" + email
				+ "]";
	}
	
	
	
	

}
