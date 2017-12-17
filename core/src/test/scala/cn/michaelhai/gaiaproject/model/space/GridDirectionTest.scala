package cn.michaelhai.gaiaproject.model.space

import org.scalatest.FlatSpec
import org.scalatest.Matchers._

class GridDirectionTest extends FlatSpec {
  behavior of "GridDirection"

  it should "have correct opposite direction" in {
    UP().oppositeDirection should be(DOWN())
    DOWN().oppositeDirection should be(UP())
    UP_LEFT().oppositeDirection should be(DOWN_RIGHT())
    DOWN_RIGHT().oppositeDirection should be(UP_LEFT())
    UP_RIGHT().oppositeDirection should be(DOWN_LEFT())
    DOWN_LEFT().oppositeDirection should be(UP_RIGHT())
  }

  it should "have correct neighbour relative positions" in {
    val upNeighbourRelativeDirections = UP().neighbourRelativeDirections()
    upNeighbourRelativeDirections.head.neighbourDirection should be(UP_LEFT())
    upNeighbourRelativeDirections.head.relativeDirection should be(UP_RIGHT())
    upNeighbourRelativeDirections(1).neighbourDirection should be(UP_RIGHT())
    upNeighbourRelativeDirections(1).relativeDirection should be(UP_LEFT())

    val upRightNeighbourRelativeDirections = UP_RIGHT().neighbourRelativeDirections()
    upRightNeighbourRelativeDirections.head.neighbourDirection should be(UP())
    upRightNeighbourRelativeDirections.head.relativeDirection should be(UP_LEFT())
    upRightNeighbourRelativeDirections(1).neighbourDirection should be(DOWN_RIGHT())
    upRightNeighbourRelativeDirections(1).relativeDirection should be(DOWN())

    val downRightNeighbourRelativeDirections = DOWN_RIGHT().neighbourRelativeDirections()
    downRightNeighbourRelativeDirections.head.neighbourDirection should be(UP_RIGHT())
    downRightNeighbourRelativeDirections.head.relativeDirection should be(UP())
    downRightNeighbourRelativeDirections(1).neighbourDirection should be(DOWN())
    downRightNeighbourRelativeDirections(1).relativeDirection should be(DOWN_LEFT())

    val downNeighbourRelativeDirections = DOWN().neighbourRelativeDirections()
    downNeighbourRelativeDirections.head.neighbourDirection should be(DOWN_RIGHT())
    downNeighbourRelativeDirections.head.relativeDirection should be(UP_RIGHT())
    downNeighbourRelativeDirections(1).neighbourDirection should be(DOWN_LEFT())
    downNeighbourRelativeDirections(1).relativeDirection should be(UP_LEFT())

    val downLeftNeighbourRelativeDirections = DOWN_LEFT().neighbourRelativeDirections()
    downLeftNeighbourRelativeDirections.head.neighbourDirection should be(DOWN())
    downLeftNeighbourRelativeDirections.head.relativeDirection should be(DOWN_LEFT())
    downLeftNeighbourRelativeDirections(1).neighbourDirection should be(UP_LEFT())
    downLeftNeighbourRelativeDirections(1).relativeDirection should be(UP())

    val upLeftNeighbourRelativeDirections = UP_LEFT().neighbourRelativeDirections()
    upLeftNeighbourRelativeDirections.head.neighbourDirection should be(DOWN_LEFT())
    upLeftNeighbourRelativeDirections.head.relativeDirection should be(DOWN())
    upLeftNeighbourRelativeDirections(1).neighbourDirection should be(UP())
    upLeftNeighbourRelativeDirections(1).relativeDirection should be(UP_RIGHT())
  }
}
