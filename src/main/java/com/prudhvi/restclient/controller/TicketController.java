package com.prudhvi.restclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.prudhvi.restclient.model.Passenger;
import com.prudhvi.restclient.model.Ticket;
import com.prudhvi.restclient.service.TicketService;

@Controller
public class TicketController {
	
	@Autowired
	TicketService ticketService;
	
	@GetMapping("/passenger")
	@ResponseBody
	public Passenger passenger(Model model) {
		Passenger passenger=ticketService.passenger();
		return passenger;
	}
	
	@PostMapping("/bookTicket")
	public String book(Passenger passenger,Model model) {
		Ticket ticket=ticketService.book(passenger);
		model.addAttribute("ticket", ticket);
		return "success";
	}
	
	@GetMapping("/")
	public String demo(Model model) {
		model.addAttribute("passenger", new Passenger());
		return "booking";
	}
}
