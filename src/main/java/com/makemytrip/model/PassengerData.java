package com.makemytrip.model;

import java.time.LocalDate;

import lombok.Data;

@Data
public class PassengerData {

	private Integer id;
	private String name;
	private String email;
	private Integer age;
	private LocalDate journeyDate;
	private String source;
	private String destination;
	private String pnrNo;
	
}
