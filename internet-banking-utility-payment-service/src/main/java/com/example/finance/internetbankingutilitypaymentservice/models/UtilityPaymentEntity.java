package com.example.finance.internetbankingutilitypaymentservice.models;
import com.example.finance.internetbankingutilitypaymentservice.model.Enum.TransactionStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "utility_payment")
public class UtilityPaymentEntity {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private Long providerId;
	    private BigDecimal amount;
	    private String referenceNumber;
	    private String account;
	    private String transactionId;

	    @Enumerated(EnumType.STRING)
	    private TransactionStatus status;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

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

		public String getTransactionId() {
			return transactionId;
		}

		public void setTransactionId(String transactionId) {
			this.transactionId = transactionId;
		}

		public TransactionStatus getStatus() {
			return status;
		}

		public void setStatus(TransactionStatus status) {
			this.status = status;
		}
	    
	    
	    
	    
}
