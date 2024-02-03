package in.ashokit.rest;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.bindings.Passenger;
import in.ashokit.bindings.Ticket;
import in.ashokit.service.TicketService;

@RestController
public class TicketRestController {

	@Autowired
	private TicketService service;
	
	@PostMapping("/ticket")
	public ResponseEntity<Ticket> bookTicket(@RequestBody Passenger p){
		
		Ticket ticket = service.bookTicket(p);
		
		return new ResponseEntity<Ticket>(ticket, HttpStatus.CREATED);
	}
	
	@GetMapping("/getTickets")
	public ResponseEntity<Collection<Ticket>> getAllTicket(){
		Collection<Ticket> allTickets = service.getAllTickets();
		return new ResponseEntity<Collection<Ticket>>(allTickets, HttpStatus.OK);
	}
}
