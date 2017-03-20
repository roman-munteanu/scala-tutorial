package com.munteanu.akkademy

import akka.actor.{Actor, Props, Status}
import akka.actor.Actor.Receive

class PingPongActor extends Actor {
  override def receive: Receive = {
    case "Ping" => sender() ! "Pong"
    case x => sender() ! Status.Failure(new Exception("Unknown message"))
  }
}

/*
actorSystem.actorOf(PingPongActor props "Table Tennis")
 */
object PingPongActor {
  def props(response: String): Props = {
    Props(classOf[PingPongActor], response)
  }
}