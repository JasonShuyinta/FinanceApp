package com.dotjson.budgetfinance.entity.mapper;

import com.dotjson.budgetfinance.entity.Expense;
import com.dotjson.budgetfinance.entity.request.ExpenseRequest;
import com.dotjson.budgetfinance.entity.response.ExpenseResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExpenseMapper {

    ExpenseResponse expenseEntityToResponse(Expense expense);

    Expense expenseRequestToEntity(ExpenseRequest request);
}
