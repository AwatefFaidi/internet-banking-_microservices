package com.example.finance.internetbankingutilitypaymentservice.dto;

import lombok.Data;
import java.math.BigDecimal;

import com.example.finance.internetbankingutilitypaymentservice.model.Enum.TransactionStatus;
@Data
public class UtilityPayment {
	private Long providerId;
    private BigDecimal amount;
    private String referenceNumber;
    private String account;
    private TransactionStatus status;
}
