package com.codewithmosh.bankapiproject.service;

import com.codewithmosh.bankapiproject.dto.TransactionsDTO;
import com.codewithmosh.bankapiproject.exception.AccountNotFoundException;
import com.codewithmosh.bankapiproject.model.Transaction;
import com.codewithmosh.bankapiproject.repository.InMemoryTransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionService {
    private final InMemoryTransactionRepository transactionRepository;

    public TransactionService(InMemoryTransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public List<TransactionsDTO> getTransactionsForAccount(String accountId) {
        List<Transaction> transactions = transactionRepository.findByAccountId(accountId);
        if (transactions.isEmpty()) {
            throw  new AccountNotFoundException("Account has no transactions yet.");
        }
        return transactions.stream()
                .map(t -> new TransactionsDTO(t.getFrom(), t.getTo(), t.getAmount(), t.getTimestamp()))
                .collect(Collectors.toList());

    }
}
