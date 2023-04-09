package com.cjc.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.cjc.response.TicketResponse;
@Repository
public class IrctcDao {

	private Map<String, TicketResponse> ticketmap = new HashMap<>();

	public String saveTicket(TicketResponse response) {

		// logic will be there to store ticket into db table 

		ticketmap.put(response.getPnr(), response);

		return response.getPnr();

	}

	public TicketResponse getTicketBypnr(String pnr) {

		// logic will be there to get ticket into db table 
		if (ticketmap.containsKey(pnr)) {

			return ticketmap.get(pnr);
		}
		return null; 

	}

}
