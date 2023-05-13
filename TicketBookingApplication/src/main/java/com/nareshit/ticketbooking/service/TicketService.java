package com.nareshit.ticketbooking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nareshit.ticketbooking.dao.TicketDao;
import com.nareshit.ticketbooking.model.Ticket;

@Service

/*
 * @Service ==> Creating Service Layer where Tranasaction Managment embedeed with this
 *
 * @Autowired ==> This annotation is going to verify specified class in IOC,
 * 						if it finds ==> it will get that instance
 *
 */
public class TicketService {

	@Autowired
	private TicketDao ticketDao;  //TicketDao ticketDao=new TicketDao();



	//Create Ticket Method
	public Ticket createTicket(Ticket inputObj) {
			return ticketDao.save(inputObj);
			//save ==> insert into tbl_ticket values (inputObj values)

			/*
			 *
			 * If inputObj primay key is null ==> Insert the data
			 * If inputObj primay key is not null and not exists the database ==> Insert the data
			 * If inputObj primay key is not null and  exists the database ==> Update the data
			 */
	}

	//Retrieve All Tickets

	public Iterable<Ticket> findAllTickets(){

		return ticketDao.findAll();
		//findAll ==> select * from tbl_ticket
		//Convert ResultSet into Iterable<Ticket>

	}



	//Retrieve Individual Ticket

	public Ticket getTicket(Integer ticketId) {

		return ticketDao.findById(ticketId)
					.orElse(new Ticket());

		//findById ==> sekect * from tbl_ticket where ticket_id=ticketId
		//findById ==> It will only consider Primary Key value only

	}



	//Update Ticket

	public Ticket updateTicket(Integer ticketId,String newEmail) {

		//update tbl_ticket set email=newEmail where ticket_id=ticketId

		Ticket dbObj=getTicket(ticketId);
		//Here dbObj.getTicketId ==> VAlue is there and exists in the database
		//Hence save Method will trigger update query


		dbObj.setEmail(newEmail);

		return ticketDao.save(dbObj);


	}


	//Delete Ticket

	public void deleteTicket(Integer ticketId) {
		ticketDao.deleteById(ticketId);

		//deleteById ==> delete from tbl_ticket where ticket_id=ticketId
	}



}
