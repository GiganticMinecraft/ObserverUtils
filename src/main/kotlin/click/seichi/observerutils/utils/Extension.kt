package click.seichi.observerutils.utils

import org.bukkit.Bukkit
import org.bukkit.Location
import java.util.*

/**
 * [org.bukkit.Location]を文字列にフォーマットする
 * @return X、Y、Z座標を`0 0 0`という順にフォーマットした[String]
 */
fun Location.formatted() = "${this.blockX} ${this.blockY} ${this.blockZ}"

/**
 * 与えられた[UUID]の[Collection]を、MinecraftIDに変換できるものは変換し、できないものは[UUID]のまま[String]として返す。空なら「`-`」を返す
 *
 * e.g. `0ea34656-b1c7-45c0-8b89-1ec55a70fe17, b66cc3f6-a045-42ad-b4b8-320f20caf140, minechan`
 */
fun Collection<UUID>.formatted() =
    this.orEmpty("-") { it.map { uuid -> Bukkit.getOfflinePlayer(uuid).name ?: uuid }.joinToString() }

/**
 * 与えられた[Collection]の先頭のアイテムと残りのアイテムのリストを返す
 * @return 与えられた[Collection]の先頭のアイテムと残りのアイテムの[List]を[Pair]を返す。[Collection]が空ならば、`null`を返す。
 */
fun <T> Collection<T>.splitFirst() = runCatching { this.first() to this.drop(1) }.getOrNull()

/**
 * 与えられた[Collection]が空ならば[default]、空でなければ[formatter]で指定された関数を適用して返す
 * @param default [Collection]が空の時に返る[String]
 * @param formatter [Collection]が空ではない時に適用する関数。初期値は[Collection.toString]を適用する。
 * @return [String]
 */
fun <T> Collection<T>.orEmpty(default: String, formatter: (Collection<T>) -> String = { this.toString() }) =
    if (this.isEmpty()) default else formatter(this)
