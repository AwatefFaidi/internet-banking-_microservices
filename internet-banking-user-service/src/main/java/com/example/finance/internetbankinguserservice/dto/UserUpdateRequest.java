package com.example.finance.internetbankinguserservice.dto;

import com.example.finance.internetbankinguserservice.model.Enum.Status;

import lombok.Data;

@Data
public class UserUpdateRequest {
    private Status status;

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
    
    
}
