package de.hkokocin.exercise_service.generators

import de.hkokocin.exercise_service.ExerciseDefinition
import de.hkokocin.toolkit.coroutines.CoroutineDispatchers
import de.hkokocin.toolkit.java.TimeProvider

class ExerciseGenerator(
    private val problemGenerator: ProblemGenerator
) {
    fun create(definition: ExerciseDefinition): Exercise = Exercise(definition, problemGenerator)
}
