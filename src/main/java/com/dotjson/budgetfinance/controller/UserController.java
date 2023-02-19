package com.dotjson.budgetfinance.controller;

import com.dotjson.budgetfinance.entity.request.UserRequest;
import com.dotjson.budgetfinance.entity.response.UserResponse;
import com.dotjson.budgetfinance.service.UserService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.dotjson.budgetfinance.utils.Constants.SWAGGER_AUTHORIZATION;

@SecurityRequirement(name = SWAGGER_AUTHORIZATION)
@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<UserResponse> getUserById(@RequestParam String userId) {
        log.info("START getUserById");
        return ResponseEntity.ok(userService.getUserById(userId));
    }

    @PutMapping
    public ResponseEntity<UserResponse> updateUser(@RequestBody UserRequest request) {
        log.info("START updateUser");
        return ResponseEntity.ok(userService.updateUser(request));
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        log.info("START getAllUsers");
        return ResponseEntity.ok(userService.getAllUsers());
    }
}
