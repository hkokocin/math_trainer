package de.hkokocin.testkit

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.runBlocking
import org.mockito.BDDMockito

fun blocking(block: suspend CoroutineScope.() -> Unit): Unit = runBlocking { block() }

fun <T> BDDMockito.BDDMyOngoingStubbing<Deferred<T>>.willDefer(data: T): BDDMockito.BDDMyOngoingStubbing<Deferred<T>> =
    willReturn(kotlinx.coroutines.CompletableDeferred(data))
