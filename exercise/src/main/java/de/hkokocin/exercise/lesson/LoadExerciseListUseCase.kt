package de.hkokocin.exercise.lesson

import de.hkokocin.exercise_service.ExerciseDefinition
import de.hkokocin.exercise_service.ExercisesRepository
import de.hkokocin.exercise_service.calculateStars
import de.hkokocin.local_data.LocalScoreRepository
import de.hkokocin.redukt.Action

class LoadExerciseListUseCase(
    private val exercisesRepository: ExercisesRepository,
    private val scoreRepository: LocalScoreRepository
) {

    suspend fun adopt(dispatch: (Action) -> Unit): List<ExerciseListItem> = exercisesRepository
        .getExerciseDefinitions()
        .await()
        .map { createItem(it, dispatch) }

    private fun createItem(
        definition: ExerciseDefinition,
        dispatch: (Action) -> Unit
    ) = ExerciseListItem(
        definition.title,
        definition.calculateStars(scoreRepository.getHighscore(definition.id))
    ) { dispatch(ExerciseSelected(definition.id)) }
}
