package com.dotjson.budgetfinance.controller;

import com.dotjson.budgetfinance.entity.Budget;
import com.dotjson.budgetfinance.entity.request.BudgetRequest;
import com.dotjson.budgetfinance.entity.response.BudgetResponse;
import com.dotjson.budgetfinance.service.BudgetService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/budget")
@RequiredArgsConstructor
public class BudgetController {

    private final BudgetService budgetService;

    @PostMapping("/save")
    public ResponseEntity<Budget> saveBudget(@RequestParam Long userId, @RequestBody BudgetRequest request) {
        log.info("STARTED saveBudget");
        return ResponseEntity.ok(budgetService.saveBudget(userId, request));
    }

    @GetMapping
    public ResponseEntity<BudgetResponse> getBudget(@RequestParam Long budgetId) {
        log.info("STARTED getBudget");
        return ResponseEntity.ok(budgetService.getBudget(budgetId));
    }

}
