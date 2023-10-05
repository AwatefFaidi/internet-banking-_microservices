package com.example.finance.internetbankingutilitypaymentservice.rest.response;

import java.math.BigDecimal;

public class AccountResponse {
	private Long number;
    private BigDecimal actualBalance;
    private Long id;
    private String type;
    private String status;
    private BigDecimal availableBalance;
	public Long getNumber() {
		return number;
	}
	public void setNumber(Long number) {
		this.number = number;
	}
	public BigDecimal getActualBalance() {
		return actualBalance;
	}
	public void setActualBalance(BigDecimal actualBalance) {
		this.actualBalance = actualBalance;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public BigDecimal getAvailableBalance() {
		return availableBalance;
	}
	public void setAvailableBalance(BigDecimal availableBalance) {
		this.availableBalance = availableBalance;
	}
    
    
    
}
