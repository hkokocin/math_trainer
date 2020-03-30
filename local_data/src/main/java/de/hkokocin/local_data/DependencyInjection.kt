package de.hkokocin.local_data

import de.hkokocin.toolkit.i
import org.kodein.di.Kodein
import org.kodein.di.erased.bind
import org.kodein.di.erased.singleton

fun localDataModule() = Kodein.Module("local_data"){

    bind<LocalScoreRepository>() with singleton { LocalScoreRepository(i()) }
}
