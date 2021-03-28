package de.hkokocin.exercise.grade.domain

import de.hkokocin.toolkit.i
import org.kodein.di.Kodein
import org.kodein.di.erased.bind
import org.kodein.di.erased.singleton

fun gradeDomainModule() = Kodein.Module("GradeDomainModule") {
    bind<LoadGradeUseCase>() with singleton { LoadGradeUseCase(i(), i()) }
}
