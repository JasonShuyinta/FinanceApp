package com.dotjson.budgetfinance.entity.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BudgetRequest {

    private String id;
    private String title;
    private double total;
    private String creationDate;
    private String endDate;
}
