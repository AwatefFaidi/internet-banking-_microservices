package com.example.finance.internetbankingutilitypaymentservice.service;
import com.example.finance.internetbankingutilitypaymentservice.model.Enum.TransactionStatus;
import com.example.finance.internetbankingutilitypaymentservice.dto.UtilityPayment;
import com.example.finance.internetbankingutilitypaymentservice.models.UtilityPaymentEntity;
import com.example.finance.internetbankingutilitypaymentservice.mapper.UtilityPaymentMapper;
import com.example.finance.internetbankingutilitypaymentservice.repository.UtilityPaymentRepository;
import com.example.finance.internetbankingutilitypaymentservice.model.rest.request.UtilityPaymentRequest;
import com.example.finance.internetbankingutilitypaymentservice.rest.response.UtilityPaymentResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class UtilityPaymentService {
	
	@Autowired
	private  UtilityPaymentRepository utilityPaymentRepository;
	@Autowired
    private UtilityPaymentMapper utilityPaymentMapper = new UtilityPaymentMapper();

    public UtilityPaymentResponse utilPayment(UtilityPaymentRequest paymentRequest) {
       // log.info("Utility payment processing {}", paymentRequest.toString());

        UtilityPaymentEntity entity = new UtilityPaymentEntity();
        BeanUtils.copyProperties(paymentRequest, entity);
        entity.setStatus(TransactionStatus.PROCESSING);
        UtilityPaymentEntity optUtilPayment = utilityPaymentRepository.save(entity);

        String transactionId = UUID.randomUUID().toString();
        optUtilPayment.setStatus(TransactionStatus.SUCCESS);
        optUtilPayment.setTransactionId(transactionId);

        utilityPaymentRepository.save(optUtilPayment);

        return new UtilityPaymentResponse("Utility Payment Successfully Processed",transactionId);
    }

    public List<UtilityPayment> readPayments(Pageable pageable) {
        Page<UtilityPaymentEntity> allUtilPayments = utilityPaymentRepository.findAll(pageable);
        return utilityPaymentMapper.convertToDtoList(allUtilPayments.getContent());
    }
}
