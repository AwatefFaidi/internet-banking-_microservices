package com.example.finance.internetbankingfundtransferservice.mapper;
import com.example.finance.internetbankingfundtransferservice.dto.FundTransfer;
import com.example.finance.internetbankingfundtransferservice.Models.FundTransferEntity;
import org.springframework.beans.BeanUtils;

public class FundTransferMapper  extends  BaseMapper<FundTransferEntity, FundTransfer> {
    @Override
    public FundTransferEntity convertToEntity(FundTransfer dto, Object... args) {
        FundTransferEntity entity = new FundTransferEntity();
        if (dto != null) {
            BeanUtils.copyProperties(dto, entity);
        }
        return entity;
    }

    @Override
    public FundTransfer convertToDto(FundTransferEntity entity, Object... args) {
        FundTransfer dto = new FundTransfer();
        if (entity != null) {
            BeanUtils.copyProperties(entity, dto);
        }
        return dto;
    }

}
