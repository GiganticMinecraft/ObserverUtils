package click.seichi.observerutils.domain.model

import enumeratum.{EnumEntry, Enum}

sealed abstract class World(val ja: String, val name: String) extends EnumEntry

object World extends Enum[World] {
  override val values: IndexedSeq[World] = findValues

  def fromJa(ja: String): Option[World] = values.find(_.ja == ja)

  def fromName(name: String): Option[World] = values.find(_.name == name)

  case object Main extends World("メイン", "world_2")

  case object SeichiWorld1 extends World("第1整地", "world_SW")

  case object SeichiWorld2 extends World("第2整地", "world_SW_2")

  case object SeichiWorld3 extends World("第3整地", "world_SW_3")

  case object SeichiWorld4 extends World("第4整地", "world_SW_4")

  case object SeichiWorldNether extends World("ネザー整地", "world_SW_nether")

  case object SeichiWorldEnd extends World("エンド整地", "world_SW_the_end")

  case object Build extends World("建築専用", "world_build")

  case object Dot extends World("ドット絵専用", "world_dot")
}
