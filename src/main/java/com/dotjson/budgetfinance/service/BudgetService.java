package com.dotjson.budgetfinance.service;

import com.dotjson.budgetfinance.entity.Budget;
import com.dotjson.budgetfinance.entity.Expense;
import com.dotjson.budgetfinance.entity.User;
import com.dotjson.budgetfinance.entity.mapper.BudgetMapper;
import com.dotjson.budgetfinance.entity.mapper.ExpenseMapper;
import com.dotjson.budgetfinance.entity.request.BudgetRequest;
import com.dotjson.budgetfinance.entity.request.ExpenseRequest;
import com.dotjson.budgetfinance.entity.response.BudgetResponse;
import com.dotjson.budgetfinance.repository.BudgetRepository;
import com.dotjson.budgetfinance.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class BudgetService {

    private final BudgetRepository budgetRepository;
    private final UserRepository userRepository;
    private final BudgetMapper budgetMapper;
    private final ExpenseMapper expenseMapper;

    public Budget saveBudget(String userId, BudgetRequest request) {
        log.info("START saveBudget with userId {}, request {}", userId, request.toString());
        Optional<User> opUser = userRepository.findById(userId);
        if(opUser.isEmpty()) {
            log.info("Could not find user with id {}", userId);
            throw new UsernameNotFoundException("Could not find user with id " + userId);
        }
        User user = opUser.get();
        Budget budget = budgetMapper.budgetRequestToEntity(request);
        budget.setId(String.valueOf(UUID.randomUUID()));
        budget.setCreationDate(LocalDateTime.now());
        user.ownsA(budget);
        userRepository.save(user);
        return budget;
    }

    public BudgetResponse getBudget(String budgetId) {
        log.info("START getBudget with id {}", budgetId);
        Optional<Budget> optionalBudget = budgetRepository.findById(budgetId);
        if(optionalBudget.isEmpty()) {
            log.info("Could not find budget with id {}", budgetId);
            return null;
        }
        Budget budget = optionalBudget.get();
        return budgetMapper.budgetEntityToResponse(budget);
    }

    public BudgetResponse addExpense(ExpenseRequest expenseRequest, String budgetId) {
        log.info("START addExpense with expenseRequest {}, budgetId {}", expenseRequest.toString(), budgetId);
        Optional<Budget> optionalBudget = budgetRepository.findById(budgetId);
        if(optionalBudget.isEmpty()) {
            log.info("Could not find budget with id {}", budgetId);
            return null;
        }
        Budget budget = optionalBudget.get();
        Expense expense = expenseMapper.expenseRequestToEntity(expenseRequest);
        expense.setId(String.valueOf(UUID.randomUUID()));
        expense.setCreatedAt(LocalDateTime.now());
        budget.hasA(expense);
        Budget response = budgetRepository.save(budget);
        return budgetMapper.budgetEntityToResponse(response);
    }

    public List<BudgetResponse> getAllBudgetsByUser(String userId) {
        log.info("START getAllBudgetsByUser");
        List<Budget> budgetList = budgetRepository.findBudgetsByUserId(userId);
        List<BudgetResponse> budgetResponses = new ArrayList<>();
        for (Budget budget: budgetList) {
            budgetResponses.add(budgetMapper.budgetEntityToResponse(budget));
        }
        return budgetResponses;
    }
}
