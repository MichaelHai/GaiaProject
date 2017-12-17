package cn.michaelhai.gaiaproject.model.space

import scala.collection.mutable

trait SpaceGrid {
  def adjacentGrids: mutable.Map[GridDirection, SpaceGrid]

  def addAdjacentGrid(gridDirection: GridDirection, neighbour: SpaceGrid): Unit
}
