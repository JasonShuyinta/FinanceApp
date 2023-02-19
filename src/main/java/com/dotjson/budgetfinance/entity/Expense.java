package com.dotjson.budgetfinance.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Node
public class Expense {

    @Id
    private String id;
    private double value;
    private String item;
    private String category;
    private LocalDateTime createdAt;
}
