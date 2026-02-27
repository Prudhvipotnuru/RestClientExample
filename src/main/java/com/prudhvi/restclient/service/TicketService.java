package com.prudhvi.restclient.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import com.prudhvi.restclient.model.Passenger;
import com.prudhvi.restclient.model.Ticket;

@Service
public class TicketService {
	
	@Value("${rest_client.passenger.url}")
	private String PASSENGER_URL;
	@Value("${rest_client.bookticket.url}")
	private String BOOKTICKET_URL;

	public Passenger passenger() {
		WebClient webClient = WebClient.create();
		Passenger passenger = webClient.get()
				.uri(PASSENGER_URL)
				.accept(MediaType.APPLICATION_JSON)
				.retrieve()
				.bodyToMono(Passenger.class).block();
		return passenger;
	}

	public Ticket book(Passenger passenger) {
		WebClient webClient=WebClient.create();
		Ticket ticket = webClient.post()
		.uri(BOOKTICKET_URL)
		.accept(MediaType.APPLICATION_JSON)
		.body(BodyInserters.fromValue(passenger))
		.header("Content-Type", "application/json")
		.retrieve()
		.bodyToMono(Ticket.class)
		.block();
		return ticket;
	}

}
