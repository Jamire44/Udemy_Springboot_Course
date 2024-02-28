package com.eazybytes.controller;

import com.eazybytes.model.Accounts;
import com.eazybytes.repository.AccountsRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    private final AccountsRepository repository;

    public AccountController(AccountsRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/myAccount")
    public Accounts getAccountDetails(@RequestParam int id){
        Accounts accounts = repository.findByCustomerId(id);
        if (accounts != null){
            return accounts;
        }else {
            return null;
        }
    }

}
