package com.dotjson.budgetfinance.service;

import com.dotjson.budgetfinance.entity.Budget;
import com.dotjson.budgetfinance.entity.User;
import com.dotjson.budgetfinance.entity.mapper.BudgetMapper;
import com.dotjson.budgetfinance.entity.request.BudgetRequest;
import com.dotjson.budgetfinance.entity.response.BudgetResponse;
import com.dotjson.budgetfinance.repository.BudgetRepository;
import com.dotjson.budgetfinance.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class BudgetService {

    private final BudgetRepository budgetRepository;
    private final UserRepository userRepository;
    private final BudgetMapper budgetMapper;

    public Budget saveBudget(Long userId, BudgetRequest request) {
        log.info("START saveBudget with userId {}, request {}", userId, request.toString());
        Optional<User> opUser = userRepository.findById(userId);
        if(opUser.isEmpty()) {
            log.info("Could not find user with id {}", userId);
            throw new UsernameNotFoundException("Could not find user with id " + userId);
        }
        User user = opUser.get();
        Budget budget = budgetMapper.budgetRequestToEntity(request);
        budget.setCreationDate(LocalDateTime.now());
        user.ownsA(budget);
        userRepository.save(user);
        return budget;
    }

    public BudgetResponse getBudget(Long budgetId) {
        log.info("START getBudget with id {}", budgetId);
        Optional<Budget> optionalBudget = budgetRepository.findById(budgetId);
        if(optionalBudget.isEmpty()) {
            log.info("Could not find budget with id {}", budgetId);
            return null;
        }
        Budget budget = optionalBudget.get();
        return budgetMapper.budgetEntityToResponse(budget);
    }
}
