package click.seichi.observerutils.domain.model.reason

import enumeratum.{EnumEntry, Enum}

sealed abstract class MendingRequestReason(val description: String) extends EnumEntry

object MendingRequestReason extends Enum[MendingRequestReason] {
  override val values: IndexedSeq[MendingRequestReason] = findValues

  def fromDescription(description: String): Option[MendingRequestReason] =
    values.find(_.description == description)

  case object FloatingBlocks extends MendingRequestReason("空中ブロック")

  case object Magma extends MendingRequestReason("マグマ放置")

  case object Water extends MendingRequestReason("水放置")

  case object Tunnel extends MendingRequestReason("トンネル状")

  case object Other extends MendingRequestReason("その他")
}
