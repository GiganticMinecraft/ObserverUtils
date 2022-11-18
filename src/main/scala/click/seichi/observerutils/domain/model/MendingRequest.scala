package click.seichi.observerutils.domain.model

import click.seichi.observerutils.domain.model.reason.MendingRequestReason

case class MendingRequest(
  reporterId: String,
  server: Server,
  world: World,
  location: Location,
  location2: Location,
  reasons: Set[MendingRequestReason],
  comments: String
)
