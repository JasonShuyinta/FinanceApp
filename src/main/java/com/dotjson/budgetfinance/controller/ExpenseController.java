package com.dotjson.budgetfinance.controller;

import com.dotjson.budgetfinance.entity.response.ExpenseResponse;
import com.dotjson.budgetfinance.service.ExpenseService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.dotjson.budgetfinance.utils.Constants.SWAGGER_AUTHORIZATION;

@SecurityRequirement(name = SWAGGER_AUTHORIZATION)
@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/expense")
public class ExpenseController {

    private final ExpenseService expenseService;

    @GetMapping("/getExpenses")
    public ResponseEntity<List<ExpenseResponse>> getExpenses(@RequestParam String budgetId) {
        log.info("STARTED getExpenses");
        return ResponseEntity.ok(expenseService.getAllExpenses(budgetId));
    }
}
