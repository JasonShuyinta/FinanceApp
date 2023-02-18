package com.dotjson.budgetfinance;

import com.dotjson.budgetfinance.entity.Budget;
import com.dotjson.budgetfinance.entity.User;
import com.dotjson.budgetfinance.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

import java.time.LocalDateTime;

@SpringBootApplication
@EnableNeo4jRepositories
public class BudgetfinanceApplication {

	@Autowired
	UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(BudgetfinanceApplication.class, args);

		Budget budget = new Budget();
		budget.setTotal(2.0);
		budget.setCreationDate(LocalDateTime.now());
		budget.setExpenses(10.56);
		User user = new User();
		user.setEmail("email@email.com");
		user.setFirstName("Jason");

	}

}
