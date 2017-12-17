package cn.michaelhai.gaiaproject.model.space

sealed abstract class SpaceGrid() {

  import GridDirection._

  private val _adjacentGrid: Map[GridDirection, Option[SpaceGrid]] = Map()

  def adjacentGrid: Map[GridDirection, Option[SpaceGrid]] = _adjacentGrid
}

sealed abstract class Planet() extends SpaceGrid

case class Space() extends SpaceGrid

case class TerraPlanet() extends Planet

case class DesertPlanet() extends Planet

case class SwampPlanet() extends Planet

case class OxidePlanet() extends Planet

case class VolcanicPlanet() extends Planet

case class TitaniumPlanet() extends Planet

case class IcePlanet() extends Planet

case class GaiaPlanet() extends Planet

case class TransdimPlanet() extends Planet