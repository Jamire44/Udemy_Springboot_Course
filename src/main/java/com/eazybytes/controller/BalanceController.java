package com.eazybytes.controller;

import com.eazybytes.model.AccountTransactions;
import com.eazybytes.repository.AccountsTransactionRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BalanceController {

    private final AccountsTransactionRepository repository;

    public BalanceController(AccountsTransactionRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/myBalance")
    public List<AccountTransactions> getBalanceDetails(@RequestParam int id){
        List<AccountTransactions> accountTransactions = repository.findByCustomerIdOOrderByTransactionDtDesc(id);
        if (accountTransactions != null){
            return accountTransactions;
        }else {
            return null;
        }
    }

}
