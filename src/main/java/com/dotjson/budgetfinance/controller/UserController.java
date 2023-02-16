package com.dotjson.budgetfinance.controller;

import com.dotjson.budgetfinance.entity.User;
import com.dotjson.budgetfinance.entity.mapper.UserMapper;
import com.dotjson.budgetfinance.entity.request.UserRequest;
import com.dotjson.budgetfinance.entity.response.UserResponse;
import com.dotjson.budgetfinance.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/user")
public class UserController {

    private final UserMapper userMapper;
    private final UserRepository userRepository;

    @PostMapping("/test")
    public ResponseEntity<UserResponse> hello(@RequestBody UserRequest userRequest) {
        User user = userMapper.userRequestToEntity(userRequest);
        User response = userRepository.save(user);
        return ResponseEntity.ok(userMapper.userEntityToResponse(response));
    }
}
