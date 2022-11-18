package click.seichi.observerutils.domain.model.reason

import enumeratum.{EnumEntry, Enum}

sealed abstract class RegionReportReason(val description: String) extends EnumEntry

object RegionReportReason extends Enum[RegionReportReason] {
  override val values: IndexedSeq[RegionReportReason] = findValues

  def fromDescription(description: String): Option[RegionReportReason] =
    values.find(_.description == description)

  case object OwnersLastQuit extends RegionReportReason("未建築または建築途中で、全Ownerのlastquitが7日以上前")

  case object OwnersPermanentBan extends RegionReportReason("全Ownerが永久BANを受けている")

  case object Duplicated extends RegionReportReason("同一箇所に異常なほど重なっている")

  case object OnlyOneBlock extends RegionReportReason("1マスのみである")

  case object Elongated extends RegionReportReason("極端に長方形である")

  case object TooUnused extends RegionReportReason("活用済みの土地が著しく少ない")

  case object NoOwnersInDot extends RegionReportReason("ドット絵が未完成なのにOwnerがいない")

  case object Other extends RegionReportReason("その他")
}
