package com.makemytrip.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.makemytrip.model.PassengerData;
import com.makemytrip.service.TicketService;

@Controller
public class TicketController {

	@Autowired
	private TicketService service;

	@GetMapping("/")
	public String loadForm(Model model) {
		PassengerData passengerData = new PassengerData();
		model.addAttribute("passenger", passengerData);
		return "book";
	}

	@PostMapping("/book-ticket")
	public String bookTicketController(Model model, @ModelAttribute PassengerData passenger) {
		try {
			String bookTicket = service.bookTicket(passenger);

			if (bookTicket == null || bookTicket.isEmpty() || bookTicket.contains("failed")) { // ✅ Check for failure
				model.addAttribute("message", "Failed to book the ticket. Please try again.");
				model.addAttribute("messageType", "error");
			} else {
				model.addAttribute("message", bookTicket);
				model.addAttribute("messageType", "success");
			}
		} catch (Exception e) {
			model.addAttribute("message", "An unexpected error occurred.");
			model.addAttribute("messageType", "error");
		}

		model.addAttribute("passenger", new PassengerData()); // Reset form
		return "book";
	}

	@GetMapping("/view")
	public String viewAllTickets(Model model) {
		List<PassengerData> viewTickets = service.viewTickets();
		model.addAttribute("ticketviewer", viewTickets);
		return "view";
	}

	@GetMapping("/download")
	public String loadPnrForm(Model model) {
		model.addAttribute("passenger", new PassengerData());
		return "download";
	}

	@PostMapping("/download-ticket")
	public String downloadTicketController(@RequestParam String pnr, Model model) {
		try {
		PassengerData downloadTicket = service.downloadTicket(pnr);

			model.addAttribute("download", downloadTicket);
			return "download-ticket";
		} catch (RuntimeException e) {
			{
				model.addAttribute("message", "No ticket found for PNR: " + pnr);
				model.addAttribute("messageType", "error");
				return "download";
			}

		}

	}
}
