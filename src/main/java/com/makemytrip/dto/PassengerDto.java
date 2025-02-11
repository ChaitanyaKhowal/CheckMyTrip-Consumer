package com.makemytrip.dto;

import java.util.List;

import com.makemytrip.model.PassengerData;

import lombok.Data;

@Data
public class PassengerDto {

	public List<PassengerData> passenger;
	
}
