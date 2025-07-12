package com.cognizant.springlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Country {
    private static final Logger LOGGER = LoggerFactory.getLogger(Country.class);

    private String code;
    private String name;

    // 1. Empty parameter constructor with debug log
    public Country() {
        LOGGER.debug("Inside Country Constructor.");
    }

    // Instance variables for code and name (already declared above)

    // 2. Generate getters and setters with debug logs
    public String getCode() {
        LOGGER.debug("Inside Country getCode() method.");
        return code;
    }

    public void setCode(String code) {
        LOGGER.debug("Inside Country setCode() method. Setting code to: {}", code);
        this.code = code;
    }

    public String getName() {
        LOGGER.debug("Inside Country getName() method.");
        return name;
    }

    public void setName(String name) {
        LOGGER.debug("Inside Country setName() method. Setting name to: {}", name);
        this.name = name;
    }

    // 3. Generate toString() method
    @Override
    public String toString() {
        return "Country [code=" + code + ", name=" + name + "]";
    }
}