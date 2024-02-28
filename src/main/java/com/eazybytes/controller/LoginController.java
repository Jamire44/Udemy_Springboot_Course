package com.eazybytes.controller;

import com.eazybytes.repository.CustomerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    private final CustomerRepository repository;


    private final PasswordEncoder passwordEncoder;

    public LoginController(CustomerRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Customer customer){
        Customer savedCustomer = null;
        ResponseEntity response = null;
        try {
            String hashedPwd = passwordEncoder.encode(customer.getPwd());
            customer.setPwd(hashedPwd);
            savedCustomer = repository.save(customer);
            if (savedCustomer.getId() > 0){
                response = ResponseEntity
                        .status(HttpStatus.CREATED)
                        .body("Given User Details are successfully registered");
            }
        }catch (Exception e){
            response = ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Issue occurred because of : " + e.getMessage());
        }
        return response;
    }
}
