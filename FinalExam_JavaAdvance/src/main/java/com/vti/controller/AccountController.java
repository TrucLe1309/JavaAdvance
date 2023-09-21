package com.vti.controller;

import com.vti.dto.AccountDTO;
import com.vti.entity.Account;
import com.vti.service.AccountService;
import com.vti.service.IAccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/accounts")
public class AccountController {
//    private AccountService accountService;
    private IAccountService accountService;

    public AccountController() {
        accountService = new AccountService();
    }

    @PostMapping()
    public ResponseEntity<?> addNewAccount(@RequestBody Account ac) {
        //...
        System.out.println(ac);
        System.out.println(ac.getRole().toString());
        accountService.addNewAccount(ac);
        return ResponseEntity.status(HttpStatus.OK).body("Add new account successfully");
    }

    @GetMapping()
    public List<AccountDTO> getListAccounts () {
        List<Account> listAc = accountService.getListAccounts();
        List<AccountDTO> listAcDTO = new ArrayList<>();
        for (Account ac : listAc) {
            AccountDTO accountDTO = new AccountDTO(ac.getId(), ac.getUsername());
            listAcDTO.add(accountDTO);
        }
        return listAcDTO;
    }

//    @DeleteMapping("/{id}")
//    public void deleteAccount(@PathVariable(name="id") int id) {
//        System.out.println("id from client: " + id);
//        accountService.deleteAccount(id);
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAccount(@PathVariable(name="id") int id) {
        System.out.println("id from client: " + id);
        accountService.deleteAccount(id);
        return ResponseEntity.status(HttpStatus.OK).body("Account deleted successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateAccount(@PathVariable(name = "id") int id, @RequestBody Account ac) {
        ac.setId(id);
        accountService.updateAccount(ac);
        return ResponseEntity.status(HttpStatus.OK).body("Account updated successfully");
    }
}
