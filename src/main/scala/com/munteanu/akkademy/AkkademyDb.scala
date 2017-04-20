package com.munteanu.akkademy

import scala.collection.mutable.Map
import akka.actor.{Actor, Status}
import akka.actor.Actor.Receive
import akka.event.Logging
import com.munteanu.akkademy.messages.{GetRequest, KeyNotFoundException, SetRequest}

import scala.collection.mutable


class AkkademyDb extends Actor {

  val log = Logging(context.system, this)
  val map: Map[String, Object] = new mutable.HashMap[String, Object]()

  override def receive: Receive = {
    case SetRequest(key: String, value: Object) => {
      log.info("Received SetRequest with key: {} and value: {}", key, value)
      map(key) = value
      sender() ! Status.Success
    }
    case GetRequest(key: String) => {
      map(key) match {
        case Some(value) => sender() ! value
        case _ => Status.Failure(KeyNotFoundException(key))
      }
    }
    case m => {
      log.info("Unknown message: {}", m)
      sender() ! Status.Failure(new ClassNotFoundException())
    }

  }
}
