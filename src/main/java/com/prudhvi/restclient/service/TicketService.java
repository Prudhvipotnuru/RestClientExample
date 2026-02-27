package com.prudhvi.restclient.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.prudhvi.restclient.model.Passenger;
import com.prudhvi.restclient.model.Ticket;

@Service
public class TicketService {

	public Passenger passenger() {
		RestTemplate rt=new RestTemplate();
		ResponseEntity<Passenger> res = rt.getForEntity("http://localhost:8080/passenger", Passenger.class);
		if(res.getStatusCode().is2xxSuccessful()) {
			return res.getBody();
		}
		return null;
	}

	public Ticket book(Passenger passenger) {
		RestTemplate rt=new RestTemplate();
		ResponseEntity<Ticket> res = rt.postForEntity("http://localhost:8080/bookTicket",passenger, Ticket.class);
		if(res.getStatusCode().is2xxSuccessful()) {
			return res.getBody();
		}
		return null;
	}

}
