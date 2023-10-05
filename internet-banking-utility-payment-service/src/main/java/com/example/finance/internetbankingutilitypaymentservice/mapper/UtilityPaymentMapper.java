package com.example.finance.internetbankingutilitypaymentservice.mapper;
import com.example.finance.internetbankingutilitypaymentservice.dto.UtilityPayment;
import com.example.finance.internetbankingutilitypaymentservice.models.UtilityPaymentEntity;
import org.springframework.beans.BeanUtils;
public class UtilityPaymentMapper extends BaseMapper<UtilityPaymentEntity, UtilityPayment> {
    @Override
    public UtilityPaymentEntity convertToEntity(UtilityPayment dto, Object... args) {
        UtilityPaymentEntity entity = new UtilityPaymentEntity();
        if (dto != null) {
            BeanUtils.copyProperties(dto, entity);
        }
        return entity;
    }

    @Override
    public UtilityPayment convertToDto(UtilityPaymentEntity entity, Object... args) {
        UtilityPayment dto = new UtilityPayment();
        if (entity != null) {
            BeanUtils.copyProperties(entity, dto);
        }
        return dto;
    }
}


