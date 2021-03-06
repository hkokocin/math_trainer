package de.hkokocin.exercise_service

import de.hkokocin.exercise_service.generators.*
import de.hkokocin.exercise_service.grade.GradeStore
import de.hkokocin.toolkit.i
import de.hkokocin.toolkit.java.TimeProvider
import org.kodein.di.Kodein
import org.kodein.di.erased.bind
import org.kodein.di.erased.provider
import org.kodein.di.erased.singleton
import kotlin.random.Random

fun exerciseServiceModule() = Kodein.Module("ServiceModule") {
    bind<Random>() with provider { Random(System.currentTimeMillis()) }
    bind<OptionsGenerator>() with provider { OptionsGenerator() }
    bind<AdditionGenerator>() with provider { AdditionGenerator(i(), i()) }
    bind<SubtractionGenerator>() with provider { SubtractionGenerator(i(), i()) }
    bind<DivisionGenerator>() with provider { DivisionGenerator(i(), i()) }
    bind<MultiplicationGenerator>() with provider { MultiplicationGenerator(i(), i()) }
    bind<ReverseAdditionGenerator>() with provider { ReverseAdditionGenerator(i(), i()) }
    bind<ReverseSubstractionGenerator>() with provider { ReverseSubstractionGenerator(i(), i()) }
    bind<ReverseMultiplicationGenerator>() with provider { ReverseMultiplicationGenerator(i(), i()) }
    bind<ProblemGenerator>() with provider { ProblemGenerator(i(), i(), i(), i(), i(), i(), i()) }
    bind<ExerciseGenerator>() with provider { ExerciseGenerator(i()) }

    bind<DefinitionsRepository>() with singleton { DefinitionsRepository(i()) }
    bind<GradeStore>() with provider { GradeStore() }

    bind<TimeProvider>() with provider { TimeProvider() }
}
