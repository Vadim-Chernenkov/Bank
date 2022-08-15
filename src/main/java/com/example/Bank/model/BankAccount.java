package com.example.Bank.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class BankAccount {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)

private int numberBankAccount;
private String currency;
private int amountMoney;

private String personalNumberOwner;

  public BankAccount() {
  }

  public int getNumberBankAccount() {
    return numberBankAccount;
  }

  public void setNumberBankAccount(int numberBankAccount) {
    this.numberBankAccount = numberBankAccount;
  }

  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public int getAmountMoney() {
    return amountMoney;
  }

  public void setAmountMoney(int amountMoney) {
    this.amountMoney = amountMoney;
  }

  public String getPersonalNumberOwner() {
    return personalNumberOwner;
  }

  public void setPersonalNumberOwner(String personalNumberOwner) {
    this.personalNumberOwner = personalNumberOwner;
  }

  @Override
  public String toString() {
    return "BankAccount{" +
        "numberBankAccount=" + numberBankAccount +
        ", currency='" + currency + '\'' +
        ", amountMoney=" + amountMoney +
        ", personalNumberOwner='" + personalNumberOwner + '\'' +
        '}';
  }
}
