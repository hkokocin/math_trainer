package de.hkokocin.exercise_service

import de.hkokocin.exercise_service.generators.Exercise
import de.hkokocin.exercise_service.generators.ExerciseGenerator
import de.hkokocin.toolkit.coroutines.scopeAsync
import kotlinx.coroutines.Deferred


class ExercisesRepository(private val exerciseGenerator: ExerciseGenerator) {

    private val exercises by lazy { ALL_LOCAL_EXERCISES }

    fun createExercise(id: String): Exercise = exerciseGenerator.create(exercises.first { it.id == id })

    suspend fun getExerciseDefinitions(): Deferred<List<ExerciseDefinition>> = scopeAsync { exercises }
}
