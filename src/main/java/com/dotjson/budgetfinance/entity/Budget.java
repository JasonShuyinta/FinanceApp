package com.dotjson.budgetfinance.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Node
public class Budget {

    @Id
    private String id;
    private String title;
    private double total;
    private LocalDateTime creationDate;
    private LocalDateTime endDate;

    @Relationship(type = "HAS")
    public Set<Expense> expenses;

    public void hasA(Expense expense) {
        if(expenses == null) {
            expenses = new HashSet<>();
        }
        expenses.add(expense);
    }
}
