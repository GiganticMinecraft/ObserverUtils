package click.seichi.observerutils.contextualexecutor

import click.seichi.observerutils.CommandBuildException
import com.github.michaelbull.result.*
import java.time.LocalDate
import java.time.format.DateTimeFormatter

object Parsers {
    fun formattedDate(vararg formatter: DateTimeFormatter, failureMessage: String): SingleArgumentParser = { str ->
        formatter.firstNotNullOfOrNull { runCatching { LocalDate.parse(str, it) }.get() }
            .toResultOr { CommandBuildException.FailedToParseArg(failureMessage) }
    }

    fun listedInt(list: List<Int>, failureMessage: String): SingleArgumentParser = { str ->
        str.split(",").mapResult { parsedList ->
            parsedList.toIntOrNull()?.takeIf { list.contains(it) }
                .toResultOr { CommandBuildException.FailedToParseArg(failureMessage) }
        }
    }

    fun singleString(failureMessage: String): SingleArgumentParser = {
        if (it.isEmpty()) { Err(CommandBuildException.FailedToParseArg(failureMessage)) }
        else Ok(it)
    }
}
