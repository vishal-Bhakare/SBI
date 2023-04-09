package com.cjc.service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.dao.IrctcDao;
import com.cjc.request.PassengerRequest;
import com.cjc.response.TicketResponse;

@Service
public class IrctctService {
	
	private Map<String, TicketResponse> ticketmap = new HashMap<>();
 @Autowired
	private IrctcDao dao;
	
	
	
	public String bookTicket(PassengerRequest request) {

		// This logic To will be Book Ticket

		TicketResponse response = new TicketResponse();

		response.setName(request.getName());
		response.setStatus("CONFORMED");
		response.setCost(5000);
		response.setFrom(request.getFrom());
		response.setTo(request.getTo());
		response.setjDate(request.getjDate());

		String pnr1 = UUID.randomUUID().toString();

		response.setPnr(pnr1);

		dao.saveTicket(response);

		return pnr1;

	}

	public TicketResponse getTicketBypnr(String pnr) {

		
		return dao.getTicketBypnr(pnr);

	}

}
