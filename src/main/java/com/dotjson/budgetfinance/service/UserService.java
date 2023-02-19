package com.dotjson.budgetfinance.service;

import com.dotjson.budgetfinance.entity.User;
import com.dotjson.budgetfinance.entity.mapper.UserMapper;
import com.dotjson.budgetfinance.entity.request.UserRequest;
import com.dotjson.budgetfinance.entity.response.UserResponse;
import com.dotjson.budgetfinance.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserResponse getUserById(String userId) {
        log.info("START getUserById");
        Optional<User> opUser = userRepository.findById(userId);
        if(opUser.isEmpty()) {
            log.info("No user found with id {}", userId);
            throw new UsernameNotFoundException("No user found with id " + userId);
        }
        User user = opUser.get();
        return userMapper.userEntityToResponse(user);
    }

    public UserResponse updateUser(UserRequest request) {
        log.info("START updateUser with request {}", request.toString());
        User user = userRepository.save(userMapper.userRequestToEntity(request));
        return userMapper.userEntityToResponse(user);
    }

    public List<UserResponse> getAllUsers() {
        log.info("START getAllUsers");
        List<User> users = userRepository.findAll();
        List<UserResponse> response = new ArrayList<>();
        for (User user: users) {
            response.add(userMapper.userEntityToResponse(user));
        }
        return response;
    }
}

