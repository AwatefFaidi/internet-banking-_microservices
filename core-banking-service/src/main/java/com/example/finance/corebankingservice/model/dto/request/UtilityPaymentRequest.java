package com.example.finance.corebankingservice.model.dto.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class UtilityPaymentRequest {

    private Long providerId;
    private BigDecimal amount;
    private String referenceNumber;
    private String account;
    
    
	public Long getProviderId() {
		return providerId;
	}
	public void setProviderId(Long providerId) {
		this.providerId = providerId;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public String getReferenceNumber() {
		return referenceNumber;
	}
	public void setReferenceNumber(String referenceNumber) {
		this.referenceNumber = referenceNumber;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
    
    
    

}
