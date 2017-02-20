package com.munteanu.classes


object MultipleInheritance {
  def main(args: Array[String]): Unit = {

    trait Property {
      def name: String
      override def toString: String = s"Property{name=$name}"
    }

    val anonymousClass = new Property {
      override def name = "AC"
    }
    println(anonymousClass)

    class X extends { val name = "X" } with Property

    val xc = new X
    println(xc)

    // early initializer
    val y = new { val name = "Y" } with Property
    println(y)

    // composition can include inheritance

    trait Logger {
      def log(category: String, msg: String): Unit = println(msg)
    }

    trait DataAccess {
      def query[A](in: String): Unit = {
        // ...
      }
    }

    trait LoggedDataAccess extends DataAccess with Logger {
      override def query[A](in: String): Unit = {
        log("QUERY", in)
        super.query(in)
      }
    }

    trait RemoteLogger extends Logger {
      override def log(category: String, msg: String): Unit = {
        // ...
      }
    }

    trait NullLogger extends Logger {
      override def log(category: String, msg: String): Unit = {}
    }

    trait HasLogger {
      val logger = new Logger {}
    }

    trait HasRemoteLogger extends HasLogger {
      override val logger: Logger = new RemoteLogger {}
    }

    trait HasNullLogger extends HasLogger {
      override val logger: Logger = new NullLogger {}
    }

    trait DataAccess2 extends HasLogger {
      def query[A](in: String): Unit = {
        logger.log("DEBUG", in)
        // ...
      }
    }

    class DataAccess3(val logger: Logger = new Logger {}) {
      // ...
    }


  }
}
