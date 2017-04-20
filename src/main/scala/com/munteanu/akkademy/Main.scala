package com.munteanu.akkademy

import akka.actor.{ActorSystem, Props}

/**
  * Created by highlander on 4/20/17.
  */
object Main {
  def main(args: Array[String]): Unit = {
    val system = ActorSystem("akkademy-actor-system")
    system.actorOf(Props[AkkademyDb], "akkademy-db")
  }
}
