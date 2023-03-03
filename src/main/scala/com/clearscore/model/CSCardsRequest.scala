package com.clearscore.model

import io.circe.Codec
import io.circe.generic.semiauto.deriveCodec

case class CSCardsRequest(name: String, creditScore: Int)

object CSCardsRequest {

  implicit val csRequestCodec: Codec[CSCardsRequest] = deriveCodec[CSCardsRequest]

}
