package com.dotjson.budgetfinance.entity.mapper;

import com.dotjson.budgetfinance.entity.Budget;
import com.dotjson.budgetfinance.entity.request.BudgetRequest;
import com.dotjson.budgetfinance.entity.response.BudgetResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BudgetMapper {

    @Mapping(target = "budget")
    BudgetResponse budgetEntityToResponse(Budget budget);

}
