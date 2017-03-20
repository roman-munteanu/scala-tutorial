package com.munteanu.akkademy

import akka.actor.{ActorRef, ActorSystem, Props}
import akka.util.Timeout
import org.scalatest.{FunSpecLike, Matchers}

import scala.concurrent.Await
import scala.concurrent.duration._
import akka.pattern.ask

class PingPongActorSpec extends FunSpecLike with Matchers {

  implicit val timeout = Timeout(5 seconds)
  val system = ActorSystem()
  val pingPongActor: ActorRef = system.actorOf(Props(classOf[PingPongActor]))

  describe("given PingPongActor") {
    describe("when sending a message") {
      it("should respond with an expected text") {
        val future = pingPongActor ? "Ping"
        val result = Await.result(future.mapTo[String], 1 second)
        result should equal("Pong")
      }
    }

    describe("when sending an unknown message") {
      it("should respond with an exception") {
        val future = pingPongActor ? "unknown"
        intercept[Exception] {
          Await.result(future.mapTo[String], 1 second)
        }
      }
    }
  }
}
