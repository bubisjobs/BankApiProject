package com.codewithmosh.bankapiproject.repository;

import com.codewithmosh.bankapiproject.model.Transaction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Repository
public class InMemoryTransactionRepository {

    private final List<Transaction> transactions = new CopyOnWriteArrayList<>();

    public void save(Transaction transaction) {
        transactions.add(transaction);
    }

    public List<Transaction> findByAccountId(String accountId) {
        List<Transaction> result = new ArrayList<>();
        for (Transaction t : transactions) {
            if (t.getFrom().equals(accountId) || t.getTo().equals(accountId)) {
                result.add(t);
            }
        }
        return result;
    }
}
