package cn.michaelhai.gaiaproject.model.space

import org.scalatest.Matchers._
import org.scalatest.{BeforeAndAfter, FunSuite}

class SpaceGridTest extends FunSuite with BeforeAndAfter {
  var spaceGrid: SpaceGrid = _

  before {
    spaceGrid = Space()
  }

  test("new SpaceGrid should have None for adjacent grids") {
    import GridDirection._
    spaceGrid.adjacentGrid.get(UP) should be(None)
    spaceGrid.adjacentGrid.get(UP_RIGHT) should be(None)
    spaceGrid.adjacentGrid.get(DOWN_RIGHT) should be(None)
    spaceGrid.adjacentGrid.get(DOWN) should be(None)
    spaceGrid.adjacentGrid.get(DOWN_LEFT) should be(None)
    spaceGrid.adjacentGrid.get(UP_LEFT) should be(None)
  }
}
