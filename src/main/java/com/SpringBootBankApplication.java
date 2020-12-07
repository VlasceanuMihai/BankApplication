package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * Project: AplicatieBancara
 * Author: mihai
 * Date: 12/7/2020
 */

@SpringBootApplication
public class SpringBootBankApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(SpringBootBankApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootBankApplication.class, args);
    }
}
