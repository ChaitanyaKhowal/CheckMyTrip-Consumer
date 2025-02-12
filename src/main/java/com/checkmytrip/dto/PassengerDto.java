package com.checkmytrip.dto;

import java.util.List;

import com.checkmytrip.model.PassengerData;

import lombok.Data;

@Data
public class PassengerDto {

	public List<PassengerData> passenger;
	
}
