package com.codewithmosh.bankapiproject.repository;
import com.codewithmosh.bankapiproject.dto.AccountDTO;
import com.codewithmosh.bankapiproject.model.Account;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class InMemoryAccountRepository {

    private final Map<String, Account> accounts = new ConcurrentHashMap<>();

    public void save(Account account) {
        accounts.put(account.getId(), account);
    }

    public Account findById(String id) {
        return accounts.get(id);
    }

    public Collection<Account> findAll() { return accounts.values(); }
}
