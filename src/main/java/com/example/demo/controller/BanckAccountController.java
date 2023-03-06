package com.example.demo.controller;

import com.example.demo.entities.BankAccount;
import com.example.demo.entities.Client;
import com.example.demo.repository.BanckAccountRepository;
import com.example.demo.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class BanckAccountController {
    @Autowired
    private  BanckAccountRepository banckAccountRepository;
    @Autowired
    private ClientRepository clientRepository;
    @GetMapping("/user/:{idUser}/accounts")
    public List<BankAccount> getallbanckAccounForThisUser(@PathVariable Long idUser){
        Optional<Client> clientTosearch = clientRepository.findById(idUser);
        return banckAccountRepository.findAllById(Collections.singleton(clientTosearch.get().getIdClient()));

    }

    @GetMapping("/accounts")
    public List<BankAccount>getAllAccount(){
        return banckAccountRepository.findAll();
    }
    @PutMapping("/users/:{id}/accounts/debit")
    public Optional<BankAccount> debitBAnckAccount(@PathVariable Long idUser, @RequestBody BankAccount accountInfo){
        Optional<Client> clientTosearch = clientRepository.findById(idUser);
        BankAccount accountToUpdate = banckAccountRepository.findAllById(Collections.singleton(clientTosearch.get().getIdClient())).get(Math.toIntExact(accountInfo.getIdBankAccount()));

        accountToUpdate.debitAccount(accountInfo.getMontantAcrediteOuAdebite());
        banckAccountRepository.save(accountToUpdate);
        return banckAccountRepository.findById(accountInfo.getIdBankAccount());
    }

    @PutMapping("/users/:{id}/accounts/credit")
    public Optional<BankAccount> creditAccountBanque(@PathVariable Long idUser, @RequestBody BankAccount accountInfo){
        Optional<Client> clientTosearch = clientRepository.findById(idUser);
        BankAccount accountToUpdate = banckAccountRepository.findAllById(Collections.singleton(clientTosearch.get().getIdClient())).get(Math.toIntExact(accountInfo.getIdBankAccount()));
        accountToUpdate.creditAccount(accountInfo.getMontantAcrediteOuAdebite());
        banckAccountRepository.save(accountToUpdate);
        return banckAccountRepository.findById(accountInfo.getIdBankAccount());
    }

}
