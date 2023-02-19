package com.dotjson.budgetfinance;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

import static com.dotjson.budgetfinance.utils.Constants.SWAGGER_AUTHORIZATION;

@SpringBootApplication
@EnableNeo4jRepositories
@SecurityScheme(name = SWAGGER_AUTHORIZATION, scheme = "bearer", type = SecuritySchemeType.HTTP, in = SecuritySchemeIn.HEADER)
public class BudgetfinanceApplication {


	public static void main(String[] args) {
		SpringApplication.run(BudgetfinanceApplication.class, args);
	}

}
