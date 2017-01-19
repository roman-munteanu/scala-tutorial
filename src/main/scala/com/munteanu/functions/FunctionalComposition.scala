package com.munteanu.functions

/**
  * Created by romunteanu on 1/19/17.
  */
object FunctionalComposition {
  def main(args: Array[String]): Unit = {


    def f(s: String) = s"f($s)"

    def g(s: String) = s"g($s)"

    val fComposeG = f _ compose g _

    val res1 = fComposeG("Yay!")
    println(res1)
  }
}
