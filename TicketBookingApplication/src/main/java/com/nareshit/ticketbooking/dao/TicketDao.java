package com.nareshit.ticketbooking.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nareshit.ticketbooking.model.Ticket;

/*
 *
 * DAO ==> Data Access Object ==> This class is used for all database operations related to ticket table
 * @Repository ==> It will check whether database connection is created already ==> Use the connection Obj
 *                 and ticket table will be used to this connection object
 *			  ==>If the database connection is not there ==> It will create connection and Use the connection Obj
 *                 for ticket table
 *
 * If i take any table ==> C ==> CREATE DATA => INSERT INTO TBL_TICKET
 *                     ==> R ==> READ THE DATA ==> SELECT * FROM TBL_TICKET
 *                     ==> U ==> UPDATE THE DATA ==> UPDATE TBL_TICKET SET ....
 *                     ==> D ==> DEETE THE DATA ==> DELETE TBL_TICKET WHERE ...
 *
 *
 * CrudRepository ==> Default Interface created by Spring boot for perfoming CRUD Operations and developers no
 * 					   need to write boiler plate code
 *                     Input1 ==> Model Class Name
 *                     Input2 ==> Data type of Primary Key of the Model class
 *
 */

@Repository
public interface TicketDao extends CrudRepository<Ticket, Integer>{

	/* We can TicketDao for all CRUD Operations
	 *
	 *    save       ==> Inserting the data and updating the data
	 *    findAll    ==> Retrieving all the records
	 *    findById   ==> Retrieving specific record
	 *    deleteByid ==> Delete the speciffic recrod
	 *
	 */


}
