package com.dotjson.budgetfinance.entity.response;

import com.dotjson.budgetfinance.utils.Category;
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
    private Category category;
    private String issuer;
    private String createdAt;
}
