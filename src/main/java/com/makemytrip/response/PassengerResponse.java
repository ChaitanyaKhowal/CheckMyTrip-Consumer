package com.makemytrip.response;

import java.util.List;

import com.makemytrip.model.PassengerData;

public class PassengerResponse {
    private List<PassengerData> dto;

    public List<PassengerData> getDto() {
        return dto;
    }

    public void setDto(List<PassengerData> dto) {
        this.dto = dto;
    }
}
