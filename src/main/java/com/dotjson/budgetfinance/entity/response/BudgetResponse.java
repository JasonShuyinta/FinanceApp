package com.dotjson.budgetfinance.entity.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BudgetResponse {

    private long id;
    private double total;
    private double expenses;
    private String creationDate;
    private String endDate;
}
