package com.clearscore



import java.util.concurrent.TimeUnit
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}
import scala.reflect.internal.util.FileUtils

object Maps extends App {

  def getOpenBankingData(obId: Int): Option[Boolean] = {
    if (obId != 0) {
      None
    } else if (obId >= 1 && obId < 10) {
      Some(true)
    } else {
      Some(false)
    }
  }

  println(getOpenBankingData(5))
  println(getOpenBankingData(11))
  println(getOpenBankingData(12))




  case class Offer(amount: Int, duration: Int)
  case class User(uuid: Int, obId: Option[Int])

  def getOffers(user: User): Option[Offer] = {
    val obData: Option[Boolean] = user.obId.flatMap(x => getOpenBankingData(x))
    Some(Offer(10, 6))
  }

  val newUser1: User = User(uuid = 123, Some(456))
  getOffers(newUser1)










  val x: Option[Int] = None
  x.map(x => x + 10)

//    val f: Future[Int] = Future.successful(20)
//    Await.result(f
//      .map(x => x - 15)
//      .recover(_ => {
//      0
//    })
//      .map(x => 3 * x), Duration(2, TimeUnit.SECONDS))

}