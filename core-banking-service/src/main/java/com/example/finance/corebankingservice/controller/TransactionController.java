package com.example.finance.corebankingservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.finance.corebankingservice.model.dto.request.FundTransferRequest;
import com.example.finance.corebankingservice.model.dto.request.UtilityPaymentRequest;
import com.example.finance.corebankingservice.service.TransactionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/transaction")
public class TransactionController {
	@Autowired
	private  TransactionService transactionService;

    @PostMapping("/fund-transfer")
    public ResponseEntity fundTransfer(@RequestBody FundTransferRequest fundTransferRequest) {

       // log.info("Fund transfer initiated in core bank from {}", fundTransferRequest.toString());
        return ResponseEntity.ok(transactionService.fundTransfer(fundTransferRequest));

    }

    @PostMapping("/util-payment")
    public ResponseEntity utilPayment(@RequestBody UtilityPaymentRequest utilityPaymentRequest) {

       // log.info("Utility Payment initiated in core bank from {}", utilityPaymentRequest.toString());
        return ResponseEntity.ok(transactionService.utilPayment(utilityPaymentRequest));

    }
}
