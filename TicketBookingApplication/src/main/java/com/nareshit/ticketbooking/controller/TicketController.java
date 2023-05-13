package com.nareshit.ticketbooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nareshit.ticketbooking.model.Ticket;
import com.nareshit.ticketbooking.service.TicketService;

@RestController
@RequestMapping(value="/tickets")
//http://localhost:8080/tickets ==>TicketController ticketController=ioc.getTicketController();
public class TicketController {


	/*
	 *
	 * JAX RS == REST SERVICES INTRODUCTION
	 *
	 *
	 * REST SERVICE ==> WEB SERVICE ==> TWO DIFFERENT PROGRAMMING LANGAUGES WANT TO COMMUNICATE WITH EACH OTHER
	 * 								==> WE MAY USE WEBSERVICES
	 *
	 * 								==> SOAP WEBSERVICES AND REST WEBSERVICES
	 *
	 *
	 *
	 *  SOAP BASED SERVICES NOT IN USE BY MAJORITY OF THE PEOPLE
	 *                           ==) 1) Data Format ...Few formats
	 *                               2) TCP protocol handshake ,..no support for HTTP
	 *                               3) Predefined Schema between client and server
	 *                               4) Stub and Skeletion are required
	 *
	 *
	 *   REST SERVICES ADVANTAGES  ==> 1) IT WORKS WITH HTTP PROTOCOL
	 *                                 2) ITS WORKS WITH JSON AND XML FORMATS
	 *                                 3) NO PREDEFINED SCHEMA AND NO CONTRACT WSDL,XSD are not there
	 *                                 4) WE CAN QUIKLY DEVELOP REST BASED SERVICES
	 *
	 *
	 *    SPRING BOOT WRITES A WRAPPER ON TOP OF JARX RS FRAMEWORK
	 *       1) MARSHALLING/UNMARSHALLING ACTIVITIES DONE BY FRAMEWORK.
	 *       MARSHALLING ==> CONVERTING JSON OBJECT TO JAVA AS WELL AS
	 *       				 JAVA OBJECT TO JSON OBJECT
	 *
	 *       TICKET OBJ=NEW TICKET();
	 *       OBJ.SETPASSENGER...
	 *       OBJ.SETTRAVEL
	 *       OBJ.SETSOURCE..
	 *       OBJ.SETDINATION..
	 *
	 *
	 *       JSON ==> JAVA SCRIPT OJBECT NOTATION
	 *
	 *           {
	 *           		"KEY":"VALUE"
	 *           		PASSENGERNAME:"VIJAY"
	 *           		SOURCESTATION:"HYDERABA"
	 *                  DESTINATION:"GOA"
	 *
	 *
	 *           }
	 *
	 *        2) IT USES JACKSON LIBRARY FOR MARSHALLING AND UNMARSHALLING
	 *
	 *        3) IT CREATES NEW ANNOTATION COMPARE TO JAX RS
	 *
	 *           @GET  ==> @GET+ @REQUESTMAPPING ==> @GETMAPPING ==> THIS IS SPRING BOOT ANNOTATION
	 *           @POST ==> @POST +  @REQUESTMAPPING ==> @POSTMAPPING ==> THIS IS SPRING BOOT ANNOTATION
	 *           @PUT ==>  @PUT  +  @REQUESTMAPPING ==> @PUTMAPPING ==> THIS IS SPRING BOOT ANNOTATION
	 *           @DELETE ==> @DELETE +  @REQUESTMAPPING ==> @DELETEMAPPING ==> THIS IS SPRING BOOT ANNOTATION
	 *
	 *
	 */


	@Autowired
	private TicketService ticketService;  //TicketService ticketService=ioc.getTicketService();


	//GET ALL TICKETS
	@GetMapping(value="/all") //http://localhost:8080/tickets/all

	//http://localhost:8080/tickets/all ==>ticketController.getAllTickets();
	public Iterable<Ticket> getAllTickets(){

		return ticketService.findAllTickets();

	}


	//GET INDIVIDIAL TICKET
	//http://localhost:8080/tickets/1 ==> 1st Ticket
	//http://localhost:8080/tickets/2 ==> 2nd Ticket
	//http://localhost:8080/tickets/3 ==> 3rd Ticket
	//http://localhost:8080/tickets/100 ==> 100th Ticket
	//http://localhost:8080/tickets/ticket/1

	//Any Variable in the URL should be added with  { }
	//@PathVariable ==> Reads the variable in the URL AND MAPS TO JAVA VARIABLE
	@GetMapping(value="/{ticketId}")
	public Ticket getTicket(@PathVariable("ticketId") Integer ticketId) {
		return ticketService.getTicket(ticketId);
	}



	//CREATE TICKET
	@PostMapping(value="/create") //http://localhost:8080/tickets/create
	//Developer no need to write JAVA TO JSON AND JSON TO JAVA CONVERSIONS
	//@RequestBody ==> Input JSON Data availble  in BODY section
	//Its going to scan body section and reads the JSON
	public Ticket createTicket(@RequestBody Ticket ticketObj) {
		return ticketService.createTicket(ticketObj);
	}





	//UPDATE TICKET

	//http://locahost:8080/tickets/1/vijay@yahoo.com
	//http://locahost:8080/tickets/2/sandhya@yahoo.com
	@PutMapping(value="/{ticketId}/{newEmail}")
	public Ticket updateTicket(
							@PathVariable("ticketId")  Integer ticketId,
							@PathVariable("newEmail") String newEmail) {
		return ticketService.updateTicket(ticketId, newEmail);
	}






	//DELETE TICKET
	//http://localhost:8080/tickets/1 ==> DELETE
	//http://localhost:8080/tickets/2 ==> DELETE

	@DeleteMapping(value="/{ticketId}")
	public void deleteTicket(@PathVariable("ticketId") Integer ticketId) {
		ticketService.deleteTicket(ticketId);
	}
}
