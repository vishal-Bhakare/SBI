package com.cjc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cjc.request.PassengerRequest;
import com.cjc.response.TicketResponse;
import com.cjc.service.IrctctService;

@RestController
public class IrctcController {

	@Autowired
	private IrctctService service;

	@PostMapping(value = "/bookTicket", consumes = { "application/xml", "application/json" })
	public ResponseEntity<String> bookTicket(@RequestBody PassengerRequest request) {
         Integer i = 20;
		String pnr = service.bookTicket(request);

		String msg = "Ticket Book is Completed :: " + pnr;

		return new ResponseEntity<>(msg, HttpStatus.CREATED);
	}

	@GetMapping(value = "/ticket/{pnr}", produces = { "application/xml", "application/json" })
	public ResponseEntity<TicketResponse> getTicket(@PathVariable String pnr) {

		TicketResponse ticket = service.getTicketBypnr(pnr);

		return new ResponseEntity<TicketResponse>(ticket, HttpStatus.OK);

	}

}
