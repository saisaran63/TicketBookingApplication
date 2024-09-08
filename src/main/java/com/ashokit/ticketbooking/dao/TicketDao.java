package com.ashokit.ticketbooking.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ashokit.ticketbooking.model.Ticket;

@Repository
//This annotation creates a database connection and ready to work with ticket table
public interface TicketDao extends CrudRepository<Ticket, Integer>{
	
	/*
	 * For Every Table what are the common operations
	 * Developer no need to write any SQL / JAVA code to perform CRUD Operations. TicketDao will take care
	 * 
	 * 1)  CREATE ==> INSERT==> save
	 * 2)  READ ==> SELECT ==> findAll,findById
	 * 3)  UPDATE ==> UPDATE ==> save
	 * 4)  DELETED ==> DELETE ==> deleteById
	 */

}
