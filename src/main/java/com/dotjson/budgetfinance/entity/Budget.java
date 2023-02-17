package com.dotjson.budgetfinance.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Node
@Data
public class Budget {

    @Id
    @GeneratedValue
    private long id;

    private double total;


}
