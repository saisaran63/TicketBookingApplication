package com.ashokit.ticketbooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashokit.ticketbooking.model.Ticket;
import com.ashokit.ticketbooking.service.TicketService;

@RestController
@RequestMapping(value="/tickets")
public class TicketController {
	
	//Exposing the service to outside world via REST PROTOCOL is called as Rest Controller
	
	/* REST PROTOCOL ==> WEB SERVICE ==> Heterogenious communication
	                                 ==> TWO different Programming Languages communcating with each other
	                                 
	                                 
	       TicketController obj=new TicketController();
	       http://localhost:8080/tickets ==> Ticket Object to be created
	       
	       
	       WEB SERVICES ==> TWO TYPES ==> 1) SOAP 2) REST
	       
	       
	       As a spring boot developer ==> We no need to write the code for Java to JSON 
	       							  ==> We no need to write the code for JSON to Java
	       							  
	       		These two functionalities are taken care by @RestController==> JACKSON Libaray
	       		
	       		
	       		
	      
	      
	      REST SERVICES ARE INTRODUCED AS PART OF JAX RS ==> Rest Services
	      
	      REPRESENTATIONAL STATE TRANSFER ==> HTTP Protocol ==> We are controlloing state
	      
	      CREATE ==> POSTMapping ==> @Post+ @RequestMapping ==> 
	      RETRIEVE ==> GET==> @Get +@RequestMapping ==> @GetMapping
	      UPDATE ==> PUT ==> @Put + @RequestMapping ==> @PutMapping
	      DELETE ==> DELETE ==> @Delete+ @RequestMapping=> @DeleteMapping
	       
	       
	                                 
	*/
	
	
	@Autowired
	private TicketService ticketService;
	
	//Create Ticket
	@PostMapping(value="/create")
	// http://localhost:8080/tickets/create ==> obj.createTicket();
	//Input ==> inputObj.json ==> Converted into Ticket.java ==> JACK SON
	//Output ==> Ticket.java ==> Converted into Ticket.json ==> JACKSON
	public Ticket createTicket(@RequestBody Ticket inputObj) {
		return ticketService.createTicket(inputObj);
	}
	
	
	//Retrieve All Tickets
	@GetMapping(value="/all")
	//http://localhost:8080/tickets/all ==> obj.getAllTickets();
	public Iterable<Ticket> getAllTickets(){
		return ticketService.getAllTickets();
	}
	
	//Retrieve Single Ticket
	@GetMapping(value="/{ticketId}")
	//http://localhost:8080/tickets/1 ==> 1st Ticket
	//http://localhost:8080/tickets/100 ==> 100th Ticket
	//http://localhost:8080/tickets/20 ==> 20th Ticket
	public Ticket getTicket(@PathVariable("ticketId") Integer ticketId) {
		return ticketService.getTicket(ticketId);
	}
	
	
	//Update Ticket
	@PutMapping(value="/{ticketId}/{newEmail}")
	//http://localhost:8080/tickets/1/vijay@yahoo.com==> 1 with email vijay@ayhoo.com
	//http://localhost:8080/tickets/100/sandhya@yahoo.com==> 100 with email sandhya@ayhoo.com
	
	public Ticket updateTicket(
			@PathVariable("ticketId") Integer ticketId, 
			@PathVariable("newEmail") String newEmail) {
		return ticketService.updateTicket(ticketId, newEmail);
	}
	
	
	//Delete Ticket
	@DeleteMapping(value="/{ticketId}")
	//http://localhost:8080/tickets/1
	public void deleteTicket(@PathVariable("ticketId") Integer ticketId)
	{
		ticketService.deleteTicket(ticketId);
	}

	

}
