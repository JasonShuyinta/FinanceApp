package com.dotjson.budgetfinance.entity.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
