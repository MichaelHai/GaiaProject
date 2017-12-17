package cn.michaelhai.gaiaproject.model.space

sealed trait GridDirection {
  def oppositeDirection: GridDirection
}

case class UP() extends GridDirection {
  override def oppositeDirection: GridDirection = DOWN()
}

case class UP_RIGHT() extends GridDirection {
  override def oppositeDirection: GridDirection = DOWN_LEFT()
}

case class DOWN_RIGHT() extends GridDirection {
  override def oppositeDirection: GridDirection = UP_LEFT()
}

case class DOWN() extends GridDirection {
  override def oppositeDirection: GridDirection = UP()
}

case class DOWN_LEFT() extends GridDirection {
  override def oppositeDirection: GridDirection = UP_RIGHT()
}

case class UP_LEFT() extends GridDirection {
  override def oppositeDirection: GridDirection = DOWN_RIGHT()
}
