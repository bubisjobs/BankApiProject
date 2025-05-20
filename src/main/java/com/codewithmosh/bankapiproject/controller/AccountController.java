package com.codewithmosh.bankapiproject.controller;

import com.codewithmosh.bankapiproject.dto.AccountDTO;
import com.codewithmosh.bankapiproject.dto.TransactionsDTO;
import com.codewithmosh.bankapiproject.dto.TransferRequestDTO;
import com.codewithmosh.bankapiproject.service.AccountService;
import com.codewithmosh.bankapiproject.service.TransactionService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    private final AccountService accountService;
    private final TransactionService transactionService;

    public AccountController(TransactionService transactionService , AccountService accountService) {
        this.accountService = accountService;
        this.transactionService = transactionService;
    }

    @PostMapping
    public ResponseEntity<AccountDTO> createAccount(@Valid @RequestBody AccountDTO accountDTO) {
        return ResponseEntity.ok(accountService.createAccount(accountDTO));
    }

    @PostMapping("/transfer")
    public ResponseEntity<String> transfer(@Valid @RequestBody TransferRequestDTO request) {
        accountService.transfer(request);
        return ResponseEntity.ok("Transfer successful");
    }

    @GetMapping("/{accountId}/transactions")
    public ResponseEntity<List<TransactionsDTO>> getTransactions(@PathVariable String accountId) {

        return ResponseEntity.ok(transactionService.getTransactionsForAccount(accountId));
    }
}
