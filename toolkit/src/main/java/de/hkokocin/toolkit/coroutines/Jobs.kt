package de.hkokocin.toolkit.coroutines

import kotlinx.coroutines.*
import timber.log.Timber
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

typealias ErrorHandler = (Throwable) -> Unit

interface Jobs {

    val isCancelled: Boolean

    fun launch(
        context: CoroutineContext = EmptyCoroutineContext,
        start: CoroutineStart = CoroutineStart.DEFAULT,
        onError: ErrorHandler = { Timber.e(it); throw it },
        onComplete: () -> Unit = {},
        block: suspend CoroutineScope.() -> Unit
    ): Job

    fun clear()
}

class AsyncJobs(context: CoroutineContext) : Jobs {

    private val supervisorJob = SupervisorJob()
    private val scope = CoroutineScope(context + supervisorJob)
    private val handler = CoroutineExceptionHandler { _, throwable ->
        Timber.e(throwable, "uncaught exception")
    }

    override val isCancelled: Boolean get() = supervisorJob.isCancelled

    override fun launch(
        context: CoroutineContext,
        start: CoroutineStart,
        onError: ErrorHandler,
        onComplete: () -> Unit,
        block: suspend CoroutineScope.() -> Unit
    ): Job {
        scope.ensureActive()

        val job = scope.launch(context + handler, start) {
            try {
                block()
            } catch (throwable: Throwable) {
                if (throwable !is CancellationException)
                    onError(throwable)
            }
        }
        job.invokeOnCompletion { onComplete() }
        return job
    }

    override fun clear() = scope.cancel()
}

