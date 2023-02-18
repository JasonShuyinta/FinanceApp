package com.dotjson.budgetfinance.entity.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BudgetRequest {
    private long id;
    private double total;
    private double expenses;
    private String endDate;
}
