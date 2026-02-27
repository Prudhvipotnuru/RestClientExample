package com.prudhvi.restclient.model;

import lombok.Data;

@Data
public class Ticket {
	private Integer ticketId;
	private Integer trainNo;
	private String passengerName;
	private Double price;
}
