package com.munteanu.classes

import com.munteanu.classes.Transmission.Transmission

/**
  * Created by munteanu on 08.05.16.
  */
object SwartzClasses {
  def main(args: Array[String]): Unit = {

    class User(val name: String) {
      def greet: String = s"Hello $name!"
      override def toString: String = s"$name"
    }

    class A {
      def hi = "Hi from A"
    }

    class B extends A {
      override def hi = "Hi from B"
    }

    class C extends B {
      override def hi = "hi C -> " + super.hi
    }
    println(new C().hi)

    val a: A = new B()
    println(a.hi)

    class Car(val make: String, var reserved: Boolean, val year: Int = 2016) {
      def reserve: Unit = { reserved = true }
    }

    val toyota = new Car("Toyota", false)
    toyota.reserve
    println(s"My ${toyota.make} is now reserved? ${toyota.reserved}")

    class Tesla(val color: String, reserved: Boolean) extends Car("Tesla", reserved)

    class Singular[A](element: A) extends Traversable[A] {
      override def foreach[U](f: (A) => U): Unit = f(element)
    }
    val p = new Singular("Planes")
    p foreach println


    abstract class Vehicle {
      val year: Int
      val transmission: Transmission = Transmission.Manual
      def color: String
    }

    class Mini(val year: Int) extends Vehicle {
      def color = "Red"
    }

    abstract class Listener {
      def trigger
    }

    val myListener = new Listener {
      def trigger {
        println("trigger impl")
      }
    }

    class Listening {
      var listener: Listener = null
      def register(l: Listener) {listener = l}
      def sendNotification(): Unit = {
        listener.trigger
      }
    }

    val notification = new Listening()
    notification.register(new Listener {
      def trigger: Unit = {
        println("Another Listener")
      }
    })
    notification.sendNotification()

    object DBConnection {
      private val db_url = "jdbc://localhost"
      private val db_user = "roman"
      private val db_pass = "munteanu"
      def apply() = new DBConnection
    }

    class DBConnection {
      private val props = Map(
        "url" -> DBConnection.db_url,
        "user" -> DBConnection.db_user,
        "pass" -> DBConnection.db_pass
      )
      println(s"Created new connection for " + props("url"))
    }

    val conn = new DBConnection

  }
}
