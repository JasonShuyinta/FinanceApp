package com.dotjson.budgetfinance.entity.mapper;

import com.dotjson.budgetfinance.entity.Budget;
import com.dotjson.budgetfinance.entity.request.BudgetRequest;
import com.dotjson.budgetfinance.entity.response.BudgetResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BudgetMapper {

    BudgetResponse budgetEntityToResponse(Budget budget);

    Budget budgetRequestToEntity(BudgetRequest request);

}
