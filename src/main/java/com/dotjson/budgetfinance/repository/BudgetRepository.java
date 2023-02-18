package com.dotjson.budgetfinance.repository;

import com.dotjson.budgetfinance.entity.Budget;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BudgetRepository extends Neo4jRepository<Budget, Long> {
}
