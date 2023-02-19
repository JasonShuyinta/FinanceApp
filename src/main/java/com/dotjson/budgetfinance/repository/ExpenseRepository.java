package com.dotjson.budgetfinance.repository;

import com.dotjson.budgetfinance.entity.Expense;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepository extends Neo4jRepository<Expense, String> {
}
