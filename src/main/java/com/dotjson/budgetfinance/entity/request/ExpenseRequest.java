package com.dotjson.budgetfinance.entity.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseRequest {

    private String id;
    private double value;
    private String item;
    private String category;
    private String createdAt;
}
