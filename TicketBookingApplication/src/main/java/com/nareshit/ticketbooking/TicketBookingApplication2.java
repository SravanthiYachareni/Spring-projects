package com.nareshit.ticketbooking;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nareshit.ticketbooking.model.Ticket;
import com.nareshit.ticketbooking.service.TicketService;

@SpringBootApplication
public class TicketBookingApplication2 implements CommandLineRunner {

	@Autowired
	private TicketService ticketService;

	public static void main(String[] args) {
		SpringApplication.run(TicketBookingApplication2.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		//This run method will be called only once during startup

		Ticket ticketObj=new Ticket();
		ticketObj.setPassengerName("RAMU");
		ticketObj.setSourceStation("HYDERABAD");
		ticketObj.setDestinationStation("GOA");
		ticketObj.setEmail("ramu@gmail.com");
		ticketObj.setTravelDate(new Date());

		ticketService.createTicket(ticketObj);

	}

}
