package com.example.finance.internetbankingfundtransferservice.dto.response;

public class FundTransferResponse {
	 private String message;
	    private String transactionId;
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
