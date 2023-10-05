package com.example.finance.corebankingservice.model.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UtilityPaymentResponse {
    private String message;
    private String transactionId;
	public UtilityPaymentResponse(String message, String transactionId) {
		super();
		this.message = message;
		this.transactionId = transactionId;
	}
    
    
}
