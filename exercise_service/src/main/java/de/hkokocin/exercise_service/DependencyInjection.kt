package de.hkokocin.exercise_service

import de.hkokocin.exercise_service.generators.*
import de.hkokocin.toolkit.i
import de.hkokocin.toolkit.java.TimeProvider
import org.kodein.di.Kodein
import org.kodein.di.erased.bind
import org.kodein.di.erased.provider
import org.kodein.di.erased.singleton

fun exerciseServiceModule() = Kodein.Module("ServiceModule") {
    bind<OptionsGenerator>() with provider { OptionsGenerator() }
    bind<AdditionGenerator>() with provider { AdditionGenerator(i()) }
    bind<SubstractionGenerator>() with provider { SubstractionGenerator(i()) }
    bind<MultiplicationGenerator>() with provider { MultiplicationGenerator(i()) }
    bind<ProblemGenerator>() with provider { ProblemGenerator(i(), i(), i()) }
    bind<ExerciseGenerator>() with provider { ExerciseGenerator(i()) }

    bind<ExercisesRepository>() with singleton { ExercisesRepository(i()) }

    bind<TimeProvider>() with provider { TimeProvider() }
}