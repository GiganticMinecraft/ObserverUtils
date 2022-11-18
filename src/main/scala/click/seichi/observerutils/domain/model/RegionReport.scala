package click.seichi.observerutils.domain.model

import click.seichi.observerutils.domain.model.reason.RegionReportReason

case class RegionReport(
  reporterId: String,
  server: Server,
  world: World,
  reasons: Set[RegionReportReason],
  regionName: String,
  regionOwners: Set[String],
  regionMembers: Set[String],
  duplicatedRegions: Set[String],
  comments: String
)
