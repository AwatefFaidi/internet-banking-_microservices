package com.example.finance.corebankingservice.service;



import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.finance.corebankingservice.model.UserEntity;
import com.example.finance.corebankingservice.model.dto.User;
import com.example.finance.corebankingservice.model.mapper.UserMapper;
import com.example.finance.corebankingservice.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private UserMapper userMapper = new UserMapper();
@Autowired
    private  UserRepository userRepository;

    public User readUser(String identification) {
        UserEntity userEntity = userRepository.findByIdentificationNumber(identification).get();
        return userMapper.convertToDto(userEntity);
    }

    public List<User> readUsers(Pageable pageable) {
       return userMapper.convertToDtoList(userRepository.findAll(pageable).getContent());
    }
    
}