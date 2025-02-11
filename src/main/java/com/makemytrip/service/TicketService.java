package com.makemytrip.service;

import java.util.Collections;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import com.makemytrip.model.PassengerData;
import com.makemytrip.response.PassengerResponse;

@Service
public class TicketService {

	public String bookTicket(PassengerData passenger) {

		String apiUrl = "http://localhost:8080/ticket";
		RestTemplate rt = new RestTemplate();

		ResponseEntity<String> forEntity = rt.postForEntity(apiUrl, passenger, String.class);

		System.out.println(forEntity.getStatusCode().value());
		System.out.println(forEntity.getBody());

		return forEntity.getBody();

	}

	public List<PassengerData> viewTickets() {
		
		String apiUrl = "http://localhost:8080/tickets";
		RestTemplate rt = new RestTemplate();

		try {

			ResponseEntity<PassengerResponse> response = rt.getForEntity(apiUrl, PassengerResponse.class);

			// Check if response is successful and body is not null
			if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
				List<PassengerData> tickets = response.getBody().getDto();
				return tickets != null ? tickets : Collections.emptyList();
			} else {
				System.out.println("Failed to fetch tickets: HTTP Status " + response.getStatusCode());
				return Collections.emptyList();
			}

		} catch (HttpStatusCodeException e) {
			System.out.println("HTTP Error fetching tickets: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error fetching tickets: " + e.getMessage());
		}

		return Collections.emptyList();
	}

	public PassengerData downloadTicket(String pnr) {
		String apiUrl = "http://localhost:8080/passenger/" + pnr;
		RestTemplate rt = new RestTemplate();

		try {
			ResponseEntity<PassengerData> response = rt.getForEntity(apiUrl, PassengerData.class);

			if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
				return response.getBody();
			} else {
				throw new RuntimeException("Ticket not found for PNR: " + pnr);
			}
		} catch (HttpStatusCodeException e) {
			throw new RuntimeException(
					"HTTP Error fetching ticket: " + e.getStatusCode() + " - " + e.getResponseBodyAsString());
		} catch (Exception e) {
			throw new RuntimeException("Unexpected error fetching ticket: " + e.getMessage());
		}
	}

}
