package com.example.finance.internetbankingutilitypaymentservice.rest.response;
import lombok.Data;
@Data
public class UtilityPaymentResponse {
	 private String message;
	    private String transactionId;
	    
	    
	    
		public UtilityPaymentResponse(String message, String transactionId) {
			super();
			this.message = message;
			this.transactionId = transactionId;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		public String getTransactionId() {
			return transactionId;
		}
		public void setTransactionId(String transactionId) {
			this.transactionId = transactionId;
		}
	    
	    
	    
}
