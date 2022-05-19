package com.ohashi.pixexample.controllers;

import com.ohashi.pixexample.entities.Account;
import com.ohashi.pixexample.services.AccountService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("account")
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public ResponseEntity<List<Account>> listAccounts() {
        return ResponseEntity.ok(this.accountService.listAccounts());
    }

    @PostMapping
    public ResponseEntity<Account> createAccount(@Valid @RequestBody Account newAccount, UriComponentsBuilder uriComponentsBuilder) {
        Account createdAccount = this.accountService.createAccount(newAccount);

        URI uri = uriComponentsBuilder.path("/account/").buildAndExpand(createdAccount.getCpf()).toUri();

        return ResponseEntity.created(uri).body(createdAccount);
    }
}