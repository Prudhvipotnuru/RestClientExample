package com.prudhvi.restclient.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.prudhvi.restclient.model.Passenger;
import com.prudhvi.restclient.model.Ticket;

@FeignClient(name = "XMLJSON")
public interface TicketFeignClient {
	@GetMapping("/getTicket/{ticketId}")
	public EntityModel<Ticket> getTicket(@PathVariable Integer ticketId);
	
	@PostMapping("/bookTicket")
	public Ticket bookTicket(@RequestBody Passenger passenger);
}
