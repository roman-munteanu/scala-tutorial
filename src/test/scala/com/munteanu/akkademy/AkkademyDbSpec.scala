package com.munteanu.akkademy

import akka.actor.ActorSystem
import akka.testkit.TestActorRef
import com.munteanu.akkademy.messages.SetRequest
import org.scalatest.{BeforeAndAfterEach, FunSpecLike, Matchers}

/**
  * Created by munteanu on 12.03.2017.
  */
class AkkademyDbSpec extends FunSpecLike with Matchers with BeforeAndAfterEach {

  implicit val system = ActorSystem()

  describe("AkkademyDb") {
    describe("given SetRequest") {
      it("should store key/value into map") {
        val actorRef = TestActorRef(new AkkademyDb)
        actorRef ! SetRequest("testKey", "testValue")
        val akkademyDb = actorRef.underlyingActor
        akkademyDb.map("testKey") should equal("testValue")
      }
    }
  }
}
