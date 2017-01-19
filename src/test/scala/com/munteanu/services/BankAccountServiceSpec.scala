package com.munteanu.services

import org.specs2.mutable.Specification
import org.specs2.specification.BeforeEach

//import org.specs2.specification.core.SpecStructure

/**
  * Created by romunteanu on 1/19/17.
  */
class BankAccountServiceSpec extends Specification with BeforeEach {
//  override def is: SpecStructure =
//    s2"""
//        This is a specification for Account Balance Service
//      """
  sequential

  val bankAccountService: BankAccountService = new BankAccountService

  "BankAccountService" should {
    "deposit an amount" in {
      val amount = 5
      bankAccountService.currentBalance must_== 0
      bankAccountService.deposit(5)
      bankAccountService.currentBalance must_== 5
    }
    "withdraw an amount" in {
      bankAccountService.deposit(10)
      bankAccountService.currentBalance must_== 10
      bankAccountService.withdraw(7)
      bankAccountService.currentBalance must_== 3
    }
    "throw an exception" in {
      bankAccountService.withdraw(5) must throwA[IllegalArgumentException]
    }
  }

  override def before: Any = {
    bankAccountService.withdraw(bankAccountService.currentBalance)
  }
}
