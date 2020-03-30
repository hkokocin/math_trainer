package de.hkokocin.exercise.lesson

import de.hkokocin.android.ActivityCommand
import de.hkokocin.redukt.Action
import de.hkokocin.redukt.ViewState

sealed class LessonViewState: ViewState{
    data class UpdateExercises(val exercises: List<ExerciseListItem>): LessonViewState()
    data class ExecuteCommand(val command: ActivityCommand): LessonViewState()
}

data class ExerciseListItem(
    val title: String,
    val stars: Int,
    val onClick: () -> Unit
)

object ACTIVITY_RESUMED: Action
data class ExerciseSelected(val exerciseDefinitionId: String): Action
