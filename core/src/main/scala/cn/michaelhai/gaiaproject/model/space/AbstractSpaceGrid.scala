package cn.michaelhai.gaiaproject.model.space

import scala.collection.mutable

abstract class AbstractSpaceGrid() extends SpaceGrid {
  private val _adjacentGrids: mutable.Map[GridDirection, SpaceGrid] = collection.mutable.Map.empty[GridDirection, SpaceGrid]

  override def adjacentGrids: mutable.Map[GridDirection, SpaceGrid] = _adjacentGrids

  override def addAdjacentGrid(gridDirection: GridDirection, adjacentGrid: SpaceGrid): Unit = {
    addEachOther(gridDirection, adjacentGrid)
  }

  private def addEachOther(gridDirection: GridDirection, adjacentGrid: SpaceGrid) = {
    val neighbour = _adjacentGrids.getOrElse(gridDirection, {
      _adjacentGrids.put(gridDirection, adjacentGrid)
      adjacentGrid.addAdjacentGrid(gridDirection.oppositeDirection, this)
      adjacentGrid
    })

    if (neighbour != adjacentGrid) throw AdjacentGridAlreadyExistException()
  }
}

abstract class Planet() extends AbstractSpaceGrid

case class Space() extends AbstractSpaceGrid

case class TerraPlanet() extends Planet

case class DesertPlanet() extends Planet

case class SwampPlanet() extends Planet

case class OxidePlanet() extends Planet

case class VolcanicPlanet() extends Planet

case class TitaniumPlanet() extends Planet

case class IcePlanet() extends Planet

case class GaiaPlanet() extends Planet

case class TransdimPlanet() extends Planet