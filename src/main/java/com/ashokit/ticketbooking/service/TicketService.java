package com.ashokit.ticketbooking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashokit.ticketbooking.dao.TicketDao;
import com.ashokit.ticketbooking.model.Ticket;

@Service //Framework consider this as a service class so that developer no need write any transactional code, any third party system
//connectivity
public class TicketService {
	
	
	//We need to call TicketDao
	
	//Tradtiional code
	//TicketDao ticketDao=new TicketDao();
	//ticketDao.......
	
	
	
	@Autowired
	private TicketDao ticketDao;//TicketDao ticketDao=new TicketDao();
	
	
	
	//Create Ticket
	
	public Ticket createTicket(Ticket inputObj) {
		return ticketDao.save(inputObj);
		//save ==> insert into tbl_ticket values(inputObj.pname,inputObj.sstation,inputObj.dstation...);
	}
	
	
	//Retrieve All Tickets
	public Iterable<Ticket> getAllTickets(){
		return ticketDao.findAll();
		//findAll ==> select * from tbl_ticket ==> 
		//Resultset ==> Need to convert Resultset into  Iterable<Ticket>
	}
	
	
	//Retrieve Single Ticket
	public Ticket getTicket(Integer ticketId) {
		return ticketDao.findById(ticketId)
				.orElse(new Ticket());
				
				
		//findById ==> select * from tbl_ticket where ticket_id=ticketId
		//Resultset convert into Ticket
	}
	
	//Update Ticket
	
	public Ticket updateTicket(Integer ticketId,String newEmail) {
		
		//update tbl_ticket set email=newEmail where ticket_id=ticketId;
		Ticket dbObj=getTicket(ticketId);
		dbObj.setEmail(newEmail);
		
		return ticketDao.save(dbObj);
		
		
		/*
		 * save ==> It will be working with insert and update
		 * save with object ==> If object.primary key is not there ==> It will insert
		 * save with object ==> if object.primary key exists ==> It will update
		 */
		
	}
	
	//Delete Ticket
	
	public void deleteTicket(Integer ticketId) {
		ticketDao.deleteById(ticketId);
		
		//deleteById ==> delete from tbl_ticket where ticket_id=ticketId
	}
	
}
