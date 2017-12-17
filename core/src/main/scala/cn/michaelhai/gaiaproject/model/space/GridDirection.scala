package cn.michaelhai.gaiaproject.model.space

sealed trait GridDirection {
  def oppositeDirection: GridDirection

  def neighbourRelativeDirections(): Seq[RelativeDirection]
}

case class RelativeDirection(neighbourDirection: GridDirection, relativeDirection: GridDirection)

case class UP() extends GridDirection {
  override def oppositeDirection: GridDirection = DOWN()

  override def neighbourRelativeDirections(): Seq[RelativeDirection] = Seq(
    RelativeDirection(UP_LEFT(), UP_RIGHT()),
    RelativeDirection(UP_RIGHT(), UP_LEFT())
  )
}

case class UP_RIGHT() extends GridDirection {
  override def oppositeDirection: GridDirection = DOWN_LEFT()

  override def neighbourRelativeDirections(): Seq[RelativeDirection] = Seq(
    RelativeDirection(UP(), UP_LEFT()),
    RelativeDirection(DOWN_RIGHT(), DOWN())
  )
}

case class DOWN_RIGHT() extends GridDirection {
  override def oppositeDirection: GridDirection = UP_LEFT()

  override def neighbourRelativeDirections(): Seq[RelativeDirection] = Seq(
    RelativeDirection(UP_RIGHT(), UP()),
    RelativeDirection(DOWN(), DOWN_LEFT())
  )
}

case class DOWN() extends GridDirection {
  override def oppositeDirection: GridDirection = UP()

  override def neighbourRelativeDirections(): Seq[RelativeDirection] = Seq(
    RelativeDirection(DOWN_RIGHT(), UP_RIGHT()),
    RelativeDirection(DOWN_LEFT(), UP_LEFT())
  )
}

case class DOWN_LEFT() extends GridDirection {
  override def oppositeDirection: GridDirection = UP_RIGHT()

  override def neighbourRelativeDirections(): Seq[RelativeDirection] = Seq(
    RelativeDirection(DOWN(), DOWN_LEFT()),
    RelativeDirection(UP_LEFT(), UP())
  )
}

case class UP_LEFT() extends GridDirection {
  override def oppositeDirection: GridDirection = DOWN_RIGHT()

  override def neighbourRelativeDirections(): Seq[RelativeDirection] = Seq(
    RelativeDirection(DOWN_LEFT(), DOWN()),
    RelativeDirection(UP(), UP_RIGHT())
  )
}
