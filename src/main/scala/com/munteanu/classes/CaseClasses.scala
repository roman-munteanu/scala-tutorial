package com.munteanu.classes

/**
  * Created by romunteanu on 1/19/17.
  */
object CaseClasses {
  def main(args: Array[String]): Unit = {

    case class Account(name: String)

    val user = Account("Tom")

    println(user)

    val res1 = List(1,2).zip(List("a","b","c","d"))
    println(res1)
  }
}
