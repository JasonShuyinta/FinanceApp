package com.dotjson.budgetfinance.controller;

import com.dotjson.budgetfinance.entity.Budget;
import com.dotjson.budgetfinance.entity.request.BudgetRequest;
import com.dotjson.budgetfinance.entity.request.ExpenseRequest;
import com.dotjson.budgetfinance.entity.response.BudgetResponse;
import com.dotjson.budgetfinance.service.BudgetService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.dotjson.budgetfinance.utils.Constants.SWAGGER_AUTHORIZATION;

@SecurityRequirement(name = SWAGGER_AUTHORIZATION)
@Slf4j
@RestController
@RequestMapping("/budget")
@RequiredArgsConstructor
public class BudgetController {

    private final BudgetService budgetService;

    @PostMapping("/save")
    public ResponseEntity<Budget> saveBudget(@RequestParam String userId, @RequestBody BudgetRequest request) {
        log.info("STARTED saveBudget");
        return ResponseEntity.ok(budgetService.saveBudget(userId, request));
    }

    @GetMapping
    public ResponseEntity<BudgetResponse> getBudget(@RequestParam String budgetId) {
        log.info("STARTED getBudget");
        return ResponseEntity.ok(budgetService.getBudget(budgetId));
    }

    @PostMapping("/addExpense")
    public ResponseEntity<BudgetResponse> addExpense(@RequestBody ExpenseRequest expenseRequest, @RequestParam String budgetId) {
        log.info("STARTED addExpenses");
        return ResponseEntity.ok(budgetService.addExpense(expenseRequest, budgetId));
    }

    @GetMapping("/all")
    public ResponseEntity<List<BudgetResponse>> getAllBudgetsByUser(@RequestParam String userId) {
        log.info("STARTED getAllBudgetsByPerson");
        return ResponseEntity.ok(budgetService.getAllBudgetsByUser(userId));
    }

    @PutMapping("/updateBudget")
    public ResponseEntity<BudgetResponse> updateBudget(@RequestBody BudgetRequest budgetRequest) {
        log.info("STARTED updateBudget");
        return ResponseEntity.ok(budgetService.updateBudget(budgetRequest));
    }


}
