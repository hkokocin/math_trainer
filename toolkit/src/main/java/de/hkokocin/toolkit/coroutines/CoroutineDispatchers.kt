package de.hkokocin.toolkit.coroutines

import kotlinx.coroutines.CoroutineDispatcher

interface CoroutineDispatchers {
    val io: CoroutineDispatcher
    val computation: CoroutineDispatcher
    val main: CoroutineDispatcher
}
