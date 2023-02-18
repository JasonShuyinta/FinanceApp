package com.dotjson.budgetfinance.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Node
public class Budget {

    @Id
    @GeneratedValue
    private Long id;
    private double total;
    private double expenses;
    private LocalDateTime creationDate;
    private LocalDateTime endDate;

}
