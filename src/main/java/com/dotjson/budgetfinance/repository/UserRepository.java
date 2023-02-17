package com.dotjson.budgetfinance.repository;

import com.dotjson.budgetfinance.entity.User;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.Optional;

public interface UserRepository extends Neo4jRepository<User, Long> {

    User findByEmail(String email);

}
