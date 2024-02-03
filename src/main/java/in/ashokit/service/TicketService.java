package in.ashokit.service;

import java.util.Collection;

import in.ashokit.bindings.Passenger;
import in.ashokit.bindings.Ticket;

public interface TicketService {

	public Ticket bookTicket(Passenger p);
	
	public Collection<Ticket> getAllTickets();
}
