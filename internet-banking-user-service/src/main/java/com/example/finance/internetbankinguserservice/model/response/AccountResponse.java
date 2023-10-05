package com.example.finance.internetbankinguserservice.model.response;

import java.math.BigDecimal;

public class AccountResponse {
	 private String number;
	    private BigDecimal actualBalance;
	    private Integer id;
	    private String type;
	    private String status;
	    private BigDecimal availableBalance;
		public String getNumber() {
			return number;
		}
		public void setNumber(String number) {
			this.number = number;
		}
		public BigDecimal getActualBalance() {
			return actualBalance;
		}
		public void setActualBalance(BigDecimal actualBalance) {
			this.actualBalance = actualBalance;
		}
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
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
