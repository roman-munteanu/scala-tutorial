package com.munteanu.services

/**
  * Created by romunteanu on 1/19/17.
  */
class BankAccountService {

  private var balance: Int = 0

  def currentBalance = balance

  def deposit(amount: Int): Unit = {
    balance += amount
  }

  def withdraw(amount: Int): Unit = {
    if (amount <= balance) {
      balance -= amount
    } else throw new IllegalArgumentException("Not enough balance")
  }
}
