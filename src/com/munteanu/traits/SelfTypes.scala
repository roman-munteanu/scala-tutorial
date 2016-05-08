package com.munteanu.traits

/**
  * Created by munteanu on 08.05.16.
  */
object SelfTypes {
  def main(args: Array[String]): Unit = {

    // self type
    class A { def hi = "Hi" }

    trait B { self: A => override def toString = "B: " + hi }

    class C extends A with B

    println(new C().toString)

    // dependency injection
    class User(val name: String) {
      def prefix = ""
      override def toString = s"$prefix $name"
    }

    trait Male { self: User =>
      override def prefix: String = "Mr"
    }

    trait Female { self: User =>
      override def prefix: String = "Mrs"
    }

    val bob = new User("Bob") with Male
    println(bob)
    val cassandra = new User("Cassandra") with Female
    println(cassandra)
  }
}
