package com.example.finance.internetbankinguserservice.repository;

import com.example.finance.internetbankinguserservice.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
