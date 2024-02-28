package com.eazybytes.repository;

import com.eazybytes.model.AccountTransactions;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AccountsTransactionRepository extends CrudRepository<AccountTransactions, Long> {

    List<AccountTransactions> findByCustomerIdOOrderByTransactionDtDesc (int customerId);

}
