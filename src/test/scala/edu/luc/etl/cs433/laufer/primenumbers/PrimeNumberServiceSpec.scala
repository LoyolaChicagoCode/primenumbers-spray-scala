package edu.luc.etl.cs433.laufer.primenumbers

import org.specs2.mutable.Specification
import spray.testkit.Specs2RouteTest
import spray.http._
import StatusCodes._


class PrimeNumberServiceSpec extends Specification with Specs2RouteTest with PrimeNumberService {
  def actorRefFactory = system
  
  "The DemoService" should {

    "return a greeting for GET requests to the root path" in {
      Get() ~> demoRoute ~> check { entityAs[String] must contain("Say hello") }
    }

    "return a 'PONG!' response for GET requests to /ping" in {
      Get("/ping") ~> demoRoute ~> check { entityAs[String] === "PONG!" }
    }

    "leave GET requests to other paths unhandled" in {
      Get("/kermit") ~> demoRoute ~> check { handled must beFalse }
    }

    "return a MethodNotAllowed error for PUT requests to the root path" in {
      Put() ~> sealRoute(demoRoute) ~> check {
        status === MethodNotAllowed
        entityAs[String] === "HTTP method not allowed, supported methods: GET, POST"
      }
    }
  }
}