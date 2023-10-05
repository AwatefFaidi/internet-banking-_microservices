package com.example.finance.internetbankingfundtransferservice.Models;
import com.example.finance.internetbankingfundtransferservice.Models.Enum.TransactionStatus;


import javax.persistence.*;
import java.math.BigDecimal;


@Entity
@Table(name = "fund_transfer")
public class FundTransferEntity {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String transactionReference;
	    private String fromAccount;
	    private String toAccount;
	    private BigDecimal amount;

	    @Enumerated(EnumType.STRING)
	    private TransactionStatus status;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getTransactionReference() {
			return transactionReference;
		}

		public void setTransactionReference(String transactionReference) {
			this.transactionReference = transactionReference;
		}

		public String getFromAccount() {
			return fromAccount;
		}

		public void setFromAccount(String fromAccount) {
			this.fromAccount = fromAccount;
		}

		public String getToAccount() {
			return toAccount;
		}

		public void setToAccount(String toAccount) {
			this.toAccount = toAccount;
		}

		public BigDecimal getAmount() {
			return amount;
		}

		public void setAmount(BigDecimal amount) {
			this.amount = amount;
		}

		public TransactionStatus getStatus() {
			return status;
		}

		public void setStatus(TransactionStatus status) {
			this.status = status;
		}
	    
	    
}
