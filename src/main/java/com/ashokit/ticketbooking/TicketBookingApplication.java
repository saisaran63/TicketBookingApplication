package com.ashokit.ticketbooking;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ashokit.ticketbooking.model.Ticket;
import com.ashokit.ticketbooking.service.TicketService;

@SpringBootApplication
public class TicketBookingApplication implements CommandLineRunner {
	
	@Autowired
	private TicketService ticketService;

	public static void main(String[] args) {
		SpringApplication.run(TicketBookingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		Ticket inputObj=new Ticket();
		inputObj.setPassengerName("ASHOK");
		inputObj.setSourceStation("HYDERABAD");
		inputObj.setDestinationStation("GOA");
		inputObj.setTravelDate(new Date());
		inputObj.setEmail("ashok@gmail.com");
		
		ticketService.createTicket(inputObj);
		
	}

}



/*


//Go Package Right click run as Spring Boot App



//After adding properties in src/main/resources
//Go to console you see /h2-console & copy,paste  into localhost:8080/h2-console
//A window is open give url :"jdbc:h2:mem:ticket"-> click connect
//Run this command select * from tbl_ticket see the results


//After that you can use postman useful for test Rest api
//Go Workspace click + ->Go Header You click "Content-Type" & "application/json" because i/p is JSON & o/p is JSON

//GET->http://localhost:8080/tickets/all->send
//POST->http://localhost:8080/tickets/create->body-> select "raw"
/* paste it{

"passengerName": "SHAREEF",
"sourceStation": "HYDERABAD",
"destinationStation": "KERALA",
"travelDate": "2024-09-03T06:54:01.856+00:00",
"email": "shareef@gmail.com"
}*/ // ->send

/*
create as same 4
http://localhost:8080/h2-console & see  Run this command select * from tbl_ticket see the results

GET->http://localhost:8080/tickets/1->send  in postman

PUT->http://localhost:8080/tickets/3/chandu@yahoo.com->send

DELETE->http://localhost:8080/tickets/4-send
*/
