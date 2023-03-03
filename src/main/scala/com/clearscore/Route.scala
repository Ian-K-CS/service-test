package com.clearscore

import cats.data.Kleisli
import cats.effect._
import com.clearscore.model.CSRequest
import com.clearscore.model.CSRequest.csRequestCodec
import com.clearscore.service.Client
import org.http4s._
import org.http4s.blaze.server.BlazeServerBuilder
import org.http4s.circe.CirceEntityCodec.{circeEntityDecoder, circeEntityEncoder}
import org.http4s.dsl.io._
import org.http4s.implicits._
import org.http4s.server.Router
//import sttp.client3._


object Route extends IOApp {

  val route: HttpRoutes[IO] = HttpRoutes.of[IO] {
    case GET -> Root / "length" / str => Ok(str.length.toString)
    case GET -> Root / "hello" / name => Ok(s"Hello $name")
    case req@POST -> Root / "creditcards" => req.as[CSRequest].flatMap(csRequest => {
      println(csRequest.name)
      Ok(IO.fromFuture(IO(Client.makeCall(csRequest))))
//      Ok(csRequest)
    })
  }

  val app: Kleisli[IO, Request[IO], Response[IO]] = Router(
    "/" -> route
  ).orNotFound

  override def run(args: List[String]): IO[ExitCode] =
    BlazeServerBuilder[IO]
      .bindHttp(8080, "localhost")
      .withHttpApp(app)
      .resource
      .useForever
      .as(ExitCode.Success)

}
