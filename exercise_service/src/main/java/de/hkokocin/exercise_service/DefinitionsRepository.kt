package de.hkokocin.exercise_service

import de.hkokocin.exercise_service.generators.Exercise
import de.hkokocin.exercise_service.generators.ExerciseGenerator


class DefinitionsRepository(private val exerciseGenerator: ExerciseGenerator) {

    private val exercises by lazy { ALL_LOCAL_EXERCISES }

    fun createExercise(id: String): Exercise = exercises
        .first { it.id == id }
        .run { exerciseGenerator.create(this) }

    fun getExercise(id: String): ExerciseDefinition = exercises
        .first { it.id == id }

}
