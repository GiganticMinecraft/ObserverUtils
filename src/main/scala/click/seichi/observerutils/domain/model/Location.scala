package click.seichi.observerutils.domain.model

case class Location(x: Int, y: Int, z: Int) {
  require(y >= 0, "Location Y must be more than or equal to 0.")
}
