package com.example.finance.corebankingservice.service;

import com.example.finance.corebankingservice.model.Enum.TransactionType;
import com.example.finance.corebankingservice.model.dto.BankAccount;
import com.example.finance.corebankingservice.model.dto.UtilityAccount;
import com.example.finance.corebankingservice.model.dto.request.FundTransferRequest;
import com.example.finance.corebankingservice.model.dto.request.UtilityPaymentRequest;
import com.example.finance.corebankingservice.model.dto.response.FundTransferResponse;
import com.example.finance.corebankingservice.model.dto.response.UtilityPaymentResponse;
import com.example.finance.corebankingservice.model.BankAccountEntity;
import com.example.finance.corebankingservice.model.TransactionEntity;
import com.example.finance.corebankingservice.repository.BankAccountRepository;
import com.example.finance.corebankingservice.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class TransactionService {
	@Autowired
    private  AccountService accountService;
	@Autowired
    private  BankAccountRepository bankAccountRepository;
	@Autowired
    private  TransactionRepository transactionRepository;

    public FundTransferResponse fundTransfer(FundTransferRequest fundTransferRequest) {

        BankAccount fromBankAccount = accountService.readBankAccount(fundTransferRequest.getFromAccount());
        BankAccount toBankAccount = accountService.readBankAccount(fundTransferRequest.getToAccount());

        //validating account balances
        validateBalance(fromBankAccount, fundTransferRequest.getAmount());

        String transactionId = internalFundTransfer(fromBankAccount, toBankAccount, fundTransferRequest.getAmount());
        return  new FundTransferResponse("Transaction successfully completed",transactionId);

    }

    
	public UtilityPaymentResponse utilPayment(UtilityPaymentRequest utilityPaymentRequest) {

        String transactionId = UUID.randomUUID().toString();

        BankAccount fromBankAccount = accountService.readBankAccount(utilityPaymentRequest.getAccount());

        //validating account balances
        validateBalance(fromBankAccount, utilityPaymentRequest.getAmount());

        UtilityAccount utilityAccount = accountService.readUtilityAccount(utilityPaymentRequest.getProviderId());

        BankAccountEntity fromAccount = bankAccountRepository.findByNumber(fromBankAccount.getNumber()).get();

        //we can call third party API to process UTIL payment from payment provider from here.

        fromAccount.setActualBalance(fromAccount.getActualBalance().subtract(utilityPaymentRequest.getAmount()));
        fromAccount.setAvailableBalance(fromAccount.getActualBalance().subtract(utilityPaymentRequest.getAmount()));

        transactionRepository.save(new TransactionEntity(TransactionType.UTILITY_PAYMENT, fromAccount,transactionId,utilityPaymentRequest.getAmount(),
        		utilityPaymentRequest.getReferenceNumber()
        		));

        return new  UtilityPaymentResponse("Utility payment successfully completed",transactionId);

    }

    private void validateBalance(BankAccount bankAccount, BigDecimal amount) {
        if (bankAccount.getActualBalance().compareTo(BigDecimal.ZERO) < 0 || bankAccount.getActualBalance().compareTo(amount) < 0) {
            throw new RuntimeException();
        }
    }

    public String internalFundTransfer(BankAccount fromBankAccount, BankAccount toBankAccount, BigDecimal amount) {

        String transactionId = UUID.randomUUID().toString();

        BankAccountEntity fromBankAccountEntity = bankAccountRepository.findByNumber(fromBankAccount.getNumber()).get();
        BankAccountEntity toBankAccountEntity = bankAccountRepository.findByNumber(toBankAccount.getNumber()).get();

        fromBankAccountEntity.setActualBalance(fromBankAccountEntity.getActualBalance().subtract(amount));
        fromBankAccountEntity.setAvailableBalance(fromBankAccountEntity.getActualBalance().subtract(amount));
        bankAccountRepository.save(fromBankAccountEntity);

        transactionRepository.save(new TransactionEntity(TransactionType.FUND_TRANSFER,fromBankAccountEntity,transactionId,
                amount,toBankAccountEntity.getNumber() ));

        toBankAccountEntity.setActualBalance(toBankAccountEntity.getActualBalance().add(amount));
        toBankAccountEntity.setAvailableBalance(toBankAccountEntity.getActualBalance().add(amount));
        bankAccountRepository.save(toBankAccountEntity);

        transactionRepository.save(new TransactionEntity(TransactionType.FUND_TRANSFER,toBankAccountEntity,transactionId,amount,toBankAccountEntity.getNumber()));
                
     
        return transactionId;

    }

	

}
