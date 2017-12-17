package cn.michaelhai.gaiaproject.model.space

import org.scalatest.FunSuite
import org.scalatest.Matchers._

class GridDirectionTest extends FunSuite {
  test("Each grid direction should have correct opposite direction") {
    UP().oppositeDirection should be(DOWN())
    DOWN().oppositeDirection should be(UP())
    UP_LEFT().oppositeDirection should be(DOWN_RIGHT())
    DOWN_RIGHT().oppositeDirection should be(UP_LEFT())
    UP_RIGHT().oppositeDirection should be(DOWN_LEFT())
    DOWN_LEFT().oppositeDirection should be(UP_RIGHT())
  }
}
