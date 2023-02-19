package com.dotjson.budgetfinance.utils;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ElementNotFoundException extends RuntimeException{

    public ElementNotFoundException() {
        super();
    }

    public ElementNotFoundException(String s) {
        super(s);
    }
}
