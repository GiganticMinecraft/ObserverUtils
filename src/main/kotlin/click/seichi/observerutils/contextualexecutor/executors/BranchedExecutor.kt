package click.seichi.observerutils.contextualexecutor.executors

import arrow.core.getOrElse
import click.seichi.observerutils.EffectOrErr
import click.seichi.observerutils.contextualexecutor.ContextualExecutor
import click.seichi.observerutils.contextualexecutor.RawCommandContext
import click.seichi.observerutils.utils.splitFirst

data class BranchedExecutor(
    val branches: Map<String, ContextualExecutor>,
    val whenArgIsInsufficient: ContextualExecutor = PrintUsageExecutor,
    val whenBranchIsNotFound: ContextualExecutor = PrintUsageExecutor
) : ContextualExecutor {
    override suspend fun executeWith(context: RawCommandContext): EffectOrErr {
        suspend fun execute(executor: ContextualExecutor) = executor.executeWith(context)

        return context.args.splitFirst().map { (head, tail) ->
            val branch = branches.getOrElse(head) { return execute(whenBranchIsNotFound) }
            val argShiftedContext = context.copy(args = tail)

            branch.executeWith(argShiftedContext)
        }.getOrElse { execute(whenArgIsInsufficient) }
    }

    override fun tabCandidatesFor(context: RawCommandContext): List<String> {
        return context.args.splitFirst().map { (head, tail) ->
            val childExecutor = branches.getOrElse(head) { return emptyList() }
            childExecutor.tabCandidatesFor(context.copy(args = tail))
        }.getOrElse { branches.keys.toList().sorted() }
    }
}