package in.ashokit.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import in.ashokit.bindings.Passenger;
import in.ashokit.bindings.Ticket;

@Service
public class TicketServiceIMPL implements TicketService{
	
	Map<Integer, Ticket> db = new HashMap<Integer, Ticket>();

	@Override
	public Ticket bookTicket(Passenger p) {
		
		Ticket t = new Ticket();
		
		Random r = new Random();
		int id = r.nextInt(10);
		t.setTicketNo(id);
		
		BeanUtils.copyProperties(p, t);
		t.setStatus("CONFIRMED");
		
		db.put(id, t);
		return t;
	}

	@Override
	public Collection<Ticket> getAllTickets() {
		
		return db.values();
	}

}
