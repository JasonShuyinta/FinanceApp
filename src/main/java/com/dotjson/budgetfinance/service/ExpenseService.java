package com.dotjson.budgetfinance.service;

import com.dotjson.budgetfinance.entity.Budget;
import com.dotjson.budgetfinance.entity.Expense;
import com.dotjson.budgetfinance.entity.mapper.ExpenseMapper;
import com.dotjson.budgetfinance.entity.response.ExpenseResponse;
import com.dotjson.budgetfinance.repository.BudgetRepository;
import com.dotjson.budgetfinance.repository.ExpenseRepository;
import com.dotjson.budgetfinance.utils.ElementNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Slf4j
@RequiredArgsConstructor
public class ExpenseService {

    private final BudgetRepository budgetRepository;
    private final ExpenseMapper expenseMapper;

    public List<ExpenseResponse> getAllExpenses(String budgetId) {
        log.info("START getAllExpenses");
        Optional<Budget> opBudget = budgetRepository.findById(budgetId);
        if(opBudget.isEmpty()) {
            log.info("Could not find budget with id {}", budgetId);
            throw new ElementNotFoundException("could not find budget");
        }
        Set<Expense> expenseList = opBudget.get().getExpenses();
        List<ExpenseResponse> response = new ArrayList<>();
        for (Expense expense: expenseList) {
            response.add(expenseMapper.expenseEntityToResponse(expense));
        }
        return response;
    }
}
