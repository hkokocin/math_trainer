package de.hkokocin.exercise.grade.domain

import de.hkokocin.exercise_service.ExerciseDefinition
import de.hkokocin.exercise_service.MAX_STARS
import de.hkokocin.exercise_service.calculateStars
import de.hkokocin.exercise_service.grade.Arithmetic
import de.hkokocin.exercise_service.grade.GradeDefinition
import de.hkokocin.exercise_service.grade.GradeStore
import de.hkokocin.local_data.LocalScoreRepository
import kotlin.math.ceil
import kotlin.math.min

data class GradeState(
    val starsCollected: Int,
    val starsRemaining: Int,
    val starsToNextLevel: Int,
    val level: Int,
    val nextLevel: Int,
    val exercises: List<ExerciseState>
)

data class ExerciseState(
    val exerciseDefinitionId: String,
    val title: String,
    val description: String,
    val stars: Int,
    val unlocked: Boolean
)

class LoadGradeUseCase(
    private val gradeStore: GradeStore,
    private val scoreRepository: LocalScoreRepository
) {

    fun adopt(arithmetic: Arithmetic): GradeState {
        val gradeDefinition = checkNotNull(gradeStore.getGrade(arithmetic))

        val starsByExercise = gradeDefinition.exercises
            .associateWith { it.calculateStars(scoreRepository.getHighscore(it.id)) }

        val collectedStars = starsByExercise.values.sum()
        val maxStars = gradeDefinition.exercises.size * MAX_STARS
        val level = (collectedStars.toFloat() * 10 / maxStars).toInt()

        val nextLevel = min(level + 1, 10)
        return GradeState(
            starsCollected = collectedStars,
            starsRemaining = maxStars - collectedStars,
            starsToNextLevel = ceil(nextLevel * maxStars / 10f).toInt() - collectedStars,
            level = level,
            nextLevel = nextLevel,
            exercises = createExerciseStates(gradeDefinition, starsByExercise)
        )
    }

    private fun createExerciseStates(
        gradeDefinition: GradeDefinition,
        starsByExercise: Map<ExerciseDefinition, Int>
    ): List<ExerciseState> = gradeDefinition.exercises.mapIndexed { index, definition ->
        val unlocked = isExerciseUnlocked(index, gradeDefinition.exercises, starsByExercise)

        ExerciseState(
            exerciseDefinitionId = definition.id,
            title = definition.title,
            description = definition.description,
            stars = starsByExercise[definition] ?: 0,
            unlocked = unlocked
        )
    }

    private fun isExerciseUnlocked(
        index: Int,
        exercises: List<ExerciseDefinition>,
        starsByExercise: Map<ExerciseDefinition, Int>
    ): Boolean {
        if (index < 1) return true

        val previousDefinition = exercises[index - 1]
        val previousExerciseStars = starsByExercise[previousDefinition] ?: 0

        return previousExerciseStars >= 2
    }
}
