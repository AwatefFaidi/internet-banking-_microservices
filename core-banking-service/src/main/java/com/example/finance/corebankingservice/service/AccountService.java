package com.example.finance.corebankingservice.service;

import com.example.finance.corebankingservice.model.dto.BankAccount;
import com.example.finance.corebankingservice.model.dto.UtilityAccount;
import com.example.finance.corebankingservice.model.BankAccountEntity;
import com.example.finance.corebankingservice.model.UtilityAccountEntity;
import com.example.finance.corebankingservice.model.mapper.BankAccountMapper;
import com.example.finance.corebankingservice.model.mapper.UtilityAccountMapper;
import com.example.finance.corebankingservice.repository.BankAccountRepository;
import com.example.finance.corebankingservice.repository.UtilityAccountRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {

    private BankAccountMapper bankAccountMapper = new BankAccountMapper();
    private UtilityAccountMapper utilityAccountMapper = new UtilityAccountMapper();
@Autowired
    private  BankAccountRepository bankAccountRepository;
@Autowired
    private  UtilityAccountRepository utilityAccountRepository;

    public BankAccount readBankAccount(String accountNumber) {
        BankAccountEntity entity = bankAccountRepository.findByNumber(accountNumber).get();
        return bankAccountMapper.convertToDto(entity);
    }

    public UtilityAccount readUtilityAccount(String provider) {
        UtilityAccountEntity utilityAccountEntity = utilityAccountRepository.findByProviderName(provider).get();
        return utilityAccountMapper.convertToDto(utilityAccountEntity);
    }

    public UtilityAccount readUtilityAccount(Long id){
        return utilityAccountMapper.convertToDto(utilityAccountRepository.findById(id).get());
    }

    
}
