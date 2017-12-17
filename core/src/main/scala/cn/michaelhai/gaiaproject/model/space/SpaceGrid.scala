package cn.michaelhai.gaiaproject.model.space

import scala.collection.mutable
import scala.util.Try

trait SpaceGrid {
  def adjacentGrids: mutable.Map[GridDirection, SpaceGrid]

  def addAdjacentGrid(gridDirection: GridDirection, neighbour: SpaceGrid): Try[Unit]
}
