package com.munteanu.akkademy

import scala.collection.mutable.Map

import akka.actor.Actor
import akka.actor.Actor.Receive
import akka.event.Logging
import com.munteanu.akkademy.messages.SetRequest


class AkkademyDb extends Actor {
  val log = Logging(context.system, this)
  val map: Map[String, Object] = Map()
  override def receive: Receive = {
    case SetRequest(key: String, value: Object) => {
      log.info("Received SetRequest with key: {} and value: {}", key, value)
      map(key) = value
    }
    case m =>
      log.info("Unknown message: {}", m)
  }
}
