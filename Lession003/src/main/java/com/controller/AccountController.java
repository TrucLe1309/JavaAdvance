package com.controller;

import com.entity.Account;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/accounts")

public class AccountController {

        @PostMapping
        public ResponseEntity<?> addNewAcount(@RequestBody Account ac) {
        return ResponseEntity.status(HttpStatus.OK).body("Add new account successfully");
        }

    }

