package de.hkokocin.exercise_service

import de.hkokocin.exercise_service.generators.Exercise
import de.hkokocin.exercise_service.generators.ExerciseGenerator
import de.hkokocin.toolkit.coroutines.scopeAsync
import kotlinx.coroutines.Deferred


class ExercisesRepository(private val exerciseGenerator: ExerciseGenerator) {

    private val exercises by lazy { ALL_LOCAL_EXERCISES }
    private val lessons by lazy { ALL_LOCAL_LESSONS }

    suspend fun createExercise(id: String): Exercise = exercises
        .first { it.id == id }
        .run { exerciseGenerator.create(this) }

    suspend fun getExerciseDefinitions(lessonId: String): Deferred<List<ExerciseDefinition>> = scopeAsync {
        lessons.first { it.id == lessonId }.exercises
    }

    suspend fun getLessonDefinitions(): Deferred<List<LessonDefinition>> = scopeAsync { lessons }

    suspend fun getLesson(id: String): LessonDefinition = getLessonDefinitions().await().first { it.id == id }
}
