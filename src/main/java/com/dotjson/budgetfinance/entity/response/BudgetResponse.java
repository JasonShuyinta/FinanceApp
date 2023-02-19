package com.dotjson.budgetfinance.entity.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BudgetResponse {

    private String id;
    private String title;
    private double total;
    private String creationDate;
    private String endDate;
}
