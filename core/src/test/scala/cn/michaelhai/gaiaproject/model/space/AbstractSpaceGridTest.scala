package cn.michaelhai.gaiaproject.model.space

import org.scalamock.scalatest.MockFactory
import org.scalatest.Matchers._
import org.scalatest.{BeforeAndAfter, FunSuite}

class AbstractSpaceGridTest extends FunSuite with BeforeAndAfter with MockFactory {
  var spaceGrid: AbstractSpaceGrid = _

  before {
    spaceGrid = new AbstractSpaceGrid {}
  }

  test("new SpaceGrid should have None for adjacent grids") {
    spaceGrid.adjacentGrids.get(UP()) should be(None)
    spaceGrid.adjacentGrids.get(UP_RIGHT()) should be(None)
    spaceGrid.adjacentGrids.get(DOWN_RIGHT()) should be(None)
    spaceGrid.adjacentGrids.get(DOWN()) should be(None)
    spaceGrid.adjacentGrids.get(DOWN_LEFT()) should be(None)
    spaceGrid.adjacentGrids.get(UP_LEFT()) should be(None)
  }

  test("SpaceGrid can be added as down neighbour of another") {
    val downNeighbour = mock[SpaceGrid]

    (downNeighbour.addAdjacentGrid _).expects(UP(), spaceGrid)

    spaceGrid.addAdjacentGrid(DOWN(), downNeighbour)

    spaceGrid.adjacentGrids.get(DOWN()) should be(Some(downNeighbour))
  }
}
