package com.dotjson.budgetfinance.repository;

import com.dotjson.budgetfinance.entity.User;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface UserRepository extends Neo4jRepository<User, String> {

    User findByEmail(String email);

}
