package com.clearscore.model

import cats.data.Nested
import io.circe.Codec
import io.circe.generic.semiauto.deriveCodec

final case class CSRequest(name: String, creditScore: Int, salary: Int)

object CSRequest {

  implicit val csRequestCodec: Codec[CSRequest] = deriveCodec[CSRequest]

}