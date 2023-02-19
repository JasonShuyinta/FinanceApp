package com.dotjson.budgetfinance.entity.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExpenseResponse {

    private String id;
    private double value;
    private String item;
    private String category;
    private String createdAt;
}
