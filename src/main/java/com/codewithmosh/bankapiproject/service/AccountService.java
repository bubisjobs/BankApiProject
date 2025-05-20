package com.codewithmosh.bankapiproject.service;

import com.codewithmosh.bankapiproject.dto.AccountDTO;
import com.codewithmosh.bankapiproject.dto.TransferRequestDTO;
import com.codewithmosh.bankapiproject.exception.AccountNotFoundException;
import com.codewithmosh.bankapiproject.exception.InsufficientFundsException;
import com.codewithmosh.bankapiproject.model.Account;
import com.codewithmosh.bankapiproject.model.Transaction;
import com.codewithmosh.bankapiproject.repository.InMemoryAccountRepository;
import com.codewithmosh.bankapiproject.repository.InMemoryTransactionRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountService {
    private final InMemoryAccountRepository accountRepository;
    private final InMemoryTransactionRepository transactionRepository;

    public AccountService(InMemoryAccountRepository accountRepository, InMemoryTransactionRepository transactionRepository) {
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }

    public AccountDTO createAccount(AccountDTO dto) {
        Account account = new Account(dto.getId(), dto.getBalance());
        accountRepository.save(account);
        return dto;
    }
    public List<AccountDTO> getAllAccounts(){

            List<AccountDTO> accounts =  accountRepository.findAll().stream()
                    .map(account -> new AccountDTO(account.getId(), account.getBalance()))
                    .collect(Collectors.toList());
        if (accounts.isEmpty()) {
            throw new AccountNotFoundException("No accounts have been created yet.");
        }
        return accounts;
    }

    public void transfer(TransferRequestDTO request) {
        Account from = accountRepository.findById(request.getFromAccountId());
        Account to = accountRepository.findById(request.getToAccountId());

        if (from == null || to == null) {
            throw new AccountNotFoundException("One or both accounts not found.");
        }
        if (from.getId().equals(to.getId())) {
            throw new AccountNotFoundException("You cannot transfer money between the same account.");
        }

        if (from.getBalance() < request.getAmount()) {
            throw new InsufficientFundsException("Insufficient funds in the source account.");
        }

        from.setBalance(from.getBalance() - request.getAmount());
        to.setBalance(to.getBalance() + request.getAmount());

        accountRepository.save(from);
        accountRepository.save(to);

        Transaction transaction = new Transaction(from.getId(), to.getId(), request.getAmount(), Instant.now().toString());
        transactionRepository.save(transaction);
    }
}
