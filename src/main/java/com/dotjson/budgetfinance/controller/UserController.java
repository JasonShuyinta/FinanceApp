package com.dotjson.budgetfinance.controller;

import com.dotjson.budgetfinance.entity.User;
import com.dotjson.budgetfinance.entity.mapper.UserMapper;
import com.dotjson.budgetfinance.entity.request.UserRequest;
import com.dotjson.budgetfinance.entity.response.UserResponse;
import com.dotjson.budgetfinance.repository.UserRepository;
import com.dotjson.budgetfinance.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<UserResponse> getUserById(@RequestParam Long userId) {
        log.info("START getUSerById");
        return ResponseEntity.ok(userService.getUserById(userId));
    }

    @PutMapping
    public ResponseEntity<UserResponse> updateUser(@RequestBody UserRequest request) {
        log.info("START updateUser");
        return ResponseEntity.ok(userService.updateUser(request));
    }
}
