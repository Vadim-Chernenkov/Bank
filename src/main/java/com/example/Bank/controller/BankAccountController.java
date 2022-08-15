package com.example.Bank.controller;

import com.example.Bank.model.BankAccount;
import com.example.Bank.repository.BankAccountRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BankAccountController {
  @Autowired
  BankAccountRepository bankAccountRepository;

@GetMapping("bankAccounts")
  String bankAccounts (Model model){
  List<BankAccount> bankAccounts = bankAccountRepository.findAll();
  model.addAttribute("bankAccounts", bankAccounts);
  return "bankAccounts";
}
  @GetMapping("delete-bankAccount")
  String delete (int numberBankAccount){
    bankAccountRepository.deleteById(numberBankAccount);
    return "redirect:bankAccounts";
  }
  @GetMapping("create-bankAccount")
  String create ( ){
        return "create-bankAccount";
}

  @PostMapping("create-bankAccount")
  String create (BankAccount bankAccount){
    bankAccountRepository.save(bankAccount);
    return "redirect:bankAccounts";
}

  @GetMapping("update-bankAccount")
  String update (Model model, int numberBankAccount){
    BankAccount bankAccount = bankAccountRepository.findById(numberBankAccount).get();
    model.addAttribute("bankAccount", bankAccount);
    return "update-bankAccount";
  }
  @PostMapping("update-bankAccount")
  String update (BankAccount bankAccount){
    bankAccountRepository.save(bankAccount);
    return "redirect:bankAccounts";
}
}
