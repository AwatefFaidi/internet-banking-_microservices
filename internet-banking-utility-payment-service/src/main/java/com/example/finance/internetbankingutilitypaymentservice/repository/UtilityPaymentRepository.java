package com.example.finance.internetbankingutilitypaymentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.finance.internetbankingutilitypaymentservice.dto.UtilityPayment;
import com.example.finance.internetbankingutilitypaymentservice.models.UtilityPaymentEntity;

public interface UtilityPaymentRepository extends JpaRepository<UtilityPaymentEntity, UtilityPayment> {
}


