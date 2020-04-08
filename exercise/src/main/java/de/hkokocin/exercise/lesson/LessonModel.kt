package de.hkokocin.exercise.lesson

import de.hkokocin.android.ActivityCommand
import de.hkokocin.redukt.Action
import de.hkokocin.redukt.ViewState

sealed class LessonViewState: ViewState{
    data class UpdateLesson(val title: String): LessonViewState()
    data class UpdateExercises(val exercises: List<ExerciseListItem>): LessonViewState()
    data class ExecuteCommand(val command: ActivityCommand): LessonViewState()
}

data class ExerciseListItem(
    val title: String,
    val stars: Int,
    val unlocked: Boolean,
    val onClick: () -> Unit
)

data class ActivityResumed(val lessonId: String): Action
data class ExerciseSelected(val exerciseDefinitionId: String): Action
