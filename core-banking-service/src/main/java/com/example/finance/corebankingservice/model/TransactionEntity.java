package com.example.finance.corebankingservice.model;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import com.example.finance.corebankingservice.model.Enum.TransactionType;

import java.math.BigDecimal;

@Builder
@Getter
@Setter
@Entity
@Table(name = "banking_core_transaction")
public class TransactionEntity {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private BigDecimal amount;

	    @Enumerated(EnumType.STRING)
	    private TransactionType transactionType;

	    private String referenceNumber;

	    private String transactionId;

	    @OneToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "account_id", referencedColumnName = "id")
	    private BankAccountEntity account;

		public TransactionEntity( TransactionType transactionType, BankAccountEntity account, String transactionId, BigDecimal amount,  String referenceNumber
				 ) {
			super();
			
			this.amount = amount;
			this.transactionType = transactionType;
			this.referenceNumber = referenceNumber;
			this.transactionId = transactionId;
			this.account = account;
		}


}
