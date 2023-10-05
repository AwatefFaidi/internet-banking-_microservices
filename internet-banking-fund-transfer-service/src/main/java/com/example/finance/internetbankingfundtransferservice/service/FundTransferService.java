package com.example.finance.internetbankingfundtransferservice.service;
import com.example.finance.internetbankingfundtransferservice.Models.Enum.*;
import com.example.finance.internetbankingfundtransferservice.dto.FundTransfer;
import com.example.finance.internetbankingfundtransferservice.dto.request.FundTransferRequest;
import com.example.finance.internetbankingfundtransferservice.dto.response.FundTransferResponse;
import com.example.finance.internetbankingfundtransferservice.Models.FundTransferEntity;
import com.example.finance.internetbankingfundtransferservice.mapper.FundTransferMapper;
import com.example.finance.internetbankingfundtransferservice.Repository.FundTransferRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service
public class FundTransferService {
	
	@Autowired
	private  FundTransferRepository fundTransferRepository;

    private FundTransferMapper mapper = new FundTransferMapper();

    public FundTransferResponse fundTransfer(FundTransferRequest request) {
        //log.info("Sending fund transfer request {}" + request.toString());

        FundTransferEntity entity = new FundTransferEntity();
        BeanUtils.copyProperties(request, entity);
        entity.setStatus(TransactionStatus.PENDING);
        FundTransferEntity optFundTransfer = fundTransferRepository.save(entity);

        FundTransferResponse fundTransferResponse = new FundTransferResponse();
        fundTransferResponse.setTransactionId(UUID.randomUUID().toString());
        fundTransferResponse.setMessage("Success");

        return fundTransferResponse;

    }

    public List<FundTransfer> readAllTransfers(Pageable pageable) {
        return mapper.convertToDtoList(fundTransferRepository.findAll(pageable).getContent());
    }
}
