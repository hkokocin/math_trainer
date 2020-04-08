package de.hkokocin.toolkit

import org.kodein.di.DKodeinAware
import org.kodein.di.erased.instance
import org.kodein.di.erased.provider

inline fun <reified T : Any> DKodeinAware.i(tag: Any? = null): T = instance(tag)
inline fun <reified T : Any> DKodeinAware.p(tag: Any? = null): () -> T = provider(tag)
