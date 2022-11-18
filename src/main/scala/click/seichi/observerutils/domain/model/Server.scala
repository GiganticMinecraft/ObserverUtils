package click.seichi.observerutils.domain.model

import enumeratum.{EnumEntry, Enum}

sealed abstract class Server(val ja: String, val id: Int) extends EnumEntry

object Server extends Enum[Server] {
  override val values: IndexedSeq[Server] = findValues

  def fromJa(ja: String): Option[Server] = values.find(_.ja == ja)

  def fromId(id: Int): Option[Server] = values.find(_.id == id)

  case object Arcadia extends Server("アルカディア", 1)

  case object Eden extends Server("エデン", 2)

  case object Valhalla extends Server("ヴァルハラ", 3)

  case object Seichi1 extends Server("第1整地専用", 5)

  case object Seichi2 extends Server("第2整地専用", 6)

  case object Public extends Server("公共施設", 7)
}
