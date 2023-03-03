def getOpenBankingData(obId: Int): Option[Boolean] = {
  if (obId < 10) {
    None
  } else if (obId % 2 == 0) {
    Some(true)
  } else {
    Some(false)
  }
}

getOpenBankingData(5)
