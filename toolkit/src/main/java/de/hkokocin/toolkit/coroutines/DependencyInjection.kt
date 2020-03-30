package de.hkokocin.toolkit.coroutines

import kotlinx.coroutines.Dispatchers
import org.kodein.di.Kodein
import org.kodein.di.erased.bind
import org.kodein.di.erased.provider

fun coroutinesModule() = Kodein.Module("toolkit.coroutines"){
    bind<Jobs>() with provider { AsyncJobs(Dispatchers.Main) }
}
