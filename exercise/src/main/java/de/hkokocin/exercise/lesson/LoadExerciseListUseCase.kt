package de.hkokocin.exercise.lesson

import de.hkokocin.exercise_service.ExercisesRepository
import de.hkokocin.exercise_service.calculateStars
import de.hkokocin.local_data.LocalScoreRepository
import de.hkokocin.redukt.Action

class LoadExerciseListUseCase(
    private val exercisesRepository: ExercisesRepository,
    private val scoreRepository: LocalScoreRepository
) {

    suspend fun adopt(lessonId: String, dispatch: (Action) -> Unit): List<ExerciseListItem> {
        val exercises = exercisesRepository
            .getExerciseDefinitions(lessonId)
            .await()

        val stars = exercises.map { it.calculateStars(scoreRepository.getHighscore(it.id)) }

        return exercises.mapIndexed { index, exercise ->
            ExerciseListItem(
                exercise.title,
                exercise.calculateStars(scoreRepository.getHighscore(exercise.id)),
                if (index == 0) true else stars[index - 1] >= 1
            ) { dispatch(ExerciseSelected(exercise.id)) }
        }
    }
}
