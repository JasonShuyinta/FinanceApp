package com.dotjson.budgetfinance.repository;

import com.dotjson.budgetfinance.entity.Budget;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BudgetRepository extends Neo4jRepository<Budget, String> {

    @Query("MATCH (u:User {id: $userId})-[:OWNS]->(b:Budget) RETURN b")
    List<Budget> findBudgetsByUserId(String userId);
}
