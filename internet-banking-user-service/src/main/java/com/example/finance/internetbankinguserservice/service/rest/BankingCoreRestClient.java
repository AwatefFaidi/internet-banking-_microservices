package com.example.finance.internetbankinguserservice.service.rest;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.finance.internetbankinguserservice.configuration.CustomFeignClientConfiguration;
import com.example.finance.internetbankinguserservice.model.response.UserResponse;

@FeignClient(name = "core-banking-service", configuration = CustomFeignClientConfiguration.class)
public interface BankingCoreRestClient {

    @RequestMapping(method = RequestMethod.GET, value = "/api/v1/user/{identification}")
    UserResponse readUser(@PathVariable("identification") String identification);

}