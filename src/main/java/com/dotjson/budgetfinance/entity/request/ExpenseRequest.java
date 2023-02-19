package com.dotjson.budgetfinance.entity.request;

import com.dotjson.budgetfinance.utils.Category;
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
    private Category category;
    private String issuer;
    private String createdAt;
}
