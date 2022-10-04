package com.kodilla.transfersrealizationservice.repository;

import com.kodilla.transfersrealizationservice.domain.Account;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.kodilla.transfersrealizationservice.service.AccountsGenerator.generateAccounts;

@Repository
@Data
public class AccountsRepository {
    //private final AccountsGenerator generator;
    private List<Account> accountList = generateAccounts();
}
