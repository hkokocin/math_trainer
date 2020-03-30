package de.hkokocin.toolkit

import org.kodein.di.DKodeinAware
import org.kodein.di.erased.instance

inline fun <reified T : Any> DKodeinAware.i(tag: Any? = null): T = instance(tag)
