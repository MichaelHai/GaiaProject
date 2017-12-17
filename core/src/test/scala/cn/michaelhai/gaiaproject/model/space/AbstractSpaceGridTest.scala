package cn.michaelhai.gaiaproject.model.space

import org.scalatest.Matchers._
import org.scalatest.{FlatSpec, OneInstancePerTest}

class AbstractSpaceGridTest extends FlatSpec with OneInstancePerTest {
  val spaceGrid: AbstractSpaceGrid = new AbstractSpaceGrid {}

  behavior of "AbstractSpaceGrid"

  it should "have None for adjacent grids after initialization" in {
    spaceGrid.adjacentGrids.get(UP()) should be(None)
    spaceGrid.adjacentGrids.get(UP_RIGHT()) should be(None)
    spaceGrid.adjacentGrids.get(DOWN_RIGHT()) should be(None)
    spaceGrid.adjacentGrids.get(DOWN()) should be(None)
    spaceGrid.adjacentGrids.get(DOWN_LEFT()) should be(None)
    spaceGrid.adjacentGrids.get(UP_LEFT()) should be(None)
  }

  it can "added another as down neighbour" in {
    val downNeighbour = new AbstractSpaceGrid {}
    spaceGrid.addAdjacentGrid(DOWN(), downNeighbour)

    spaceGrid.adjacentGrids.get(DOWN()) should be(Some(downNeighbour))
  }

  it should "throw Exception when adding to a direction exists grid" in {
    val downNeighbour = new AbstractSpaceGrid {}
    val faultNeighbour = new AbstractSpaceGrid {}

    spaceGrid.addAdjacentGrid(DOWN(), downNeighbour)

    try {
      spaceGrid.addAdjacentGrid(DOWN(), faultNeighbour)
      fail()
    } catch {
      case _: AdjacentGridAlreadyExistException =>
    }
  }
}
