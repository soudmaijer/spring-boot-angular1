package com.hotel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@SpringBootApplication
@RestController
public class HotelApplication {

    @PostMapping(value = "/register", produces = APPLICATION_JSON_UTF8_VALUE)
    public Account register(@RequestBody Account account, @RequestParam String type) {
        List<String> validationErrors = new ArrayList<>();

        if (type.equals("customer")) {
            PasswordValidator.validateCustomerPassword(account.getPassword(), validationErrors);
        } else if (type.equals("employee")) {
            PasswordValidator.validateEmployeePassword(account.getPassword(), validationErrors);
        }
        if (validationErrors.size() > 0) {
            StringBuilder sb = new StringBuilder();
            for (String validationError : validationErrors) {
                sb.append(validationError).append(" ");
            }
            throw new PasswordValidationException("Wachtwoord voldoet niet aan de volgende eisen: " + sb.toString());
        }
        return account;
    }

    public static void main(String[] args) {
        SpringApplication.run(HotelApplication.class, args);
    }
}