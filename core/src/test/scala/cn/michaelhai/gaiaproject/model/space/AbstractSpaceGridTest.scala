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

  it can "add a third grid adjacent to both" in {
    val upNeighbour = new AbstractSpaceGrid {}
    val upRightNeighbour = new AbstractSpaceGrid {}
    val downLeftNeighbour = new AbstractSpaceGrid {}
    val upLeftNeighbour = new AbstractSpaceGrid {}

    spaceGrid.addAdjacentGrid(UP(), upNeighbour)
    spaceGrid.addAdjacentGrid(UP_RIGHT(), upRightNeighbour)
    spaceGrid.addAdjacentGrid(DOWN_LEFT(), downLeftNeighbour)
    spaceGrid.addAdjacentGrid(UP_LEFT(), upLeftNeighbour)

    upNeighbour.adjacentGrids.get(DOWN_RIGHT()) should be(Some(upRightNeighbour))
    upNeighbour.adjacentGrids.get(DOWN_LEFT()) should be(Some(upLeftNeighbour))
    upRightNeighbour.adjacentGrids.get(UP_LEFT()) should be(Some(upNeighbour))
    upLeftNeighbour.adjacentGrids.get(UP_RIGHT()) should be(Some(upNeighbour))
    upLeftNeighbour.adjacentGrids.get(DOWN()) should be(Some(downLeftNeighbour))
    downLeftNeighbour.adjacentGrids.get(UP()) should be(Some(upLeftNeighbour))

    downLeftNeighbour.adjacentGrids.get(DOWN_RIGHT()) should be(None)
    spaceGrid.adjacentGrids.get(DOWN()) should be(None)

  }
}
