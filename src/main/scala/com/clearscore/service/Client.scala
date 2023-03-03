package com.clearscore.service

import com.clearscore.model.CSCardsRequest.csRequestCodec
import com.clearscore.model.{CSCardsRequest, CSRequest}
import sttp.client3._
import sttp.client3.circe.circeBodySerializer

import scala.concurrent.Future


object Client {

  def makeCall(request: CSRequest): Future[String] = {
    val clientRequest: CSCardsRequest = CSCardsRequest(request.name, request.creditScore)
    println(clientRequest)
    val client = SimpleHttpClient()
    client.send(basicRequest.body(clientRequest).post(uri"https://app.clearscore.com/api/global/backend-tech-test/v1/cards")).body match {
      case Right(body) => Future.successful(body)
      case Left(body) =>
        println(s"$body")
        Future.failed(new RuntimeException("error in request"))
    }
  }

}
