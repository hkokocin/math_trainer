package de.hkokocin.exercise.grade.ui

import de.hkokocin.android.ActivityCommand
import de.hkokocin.exercise.grade.domain.GradeState
import de.hkokocin.redukt.Action
import de.hkokocin.redukt.ViewState

sealed class GradeViewState : ViewState {
    data class Command(val command: ActivityCommand) : GradeViewState()

    data class Data(
        val grade: GradeState,
        val exercises: List<ExerciseListItem>
    ) : GradeViewState()
}

data class ExerciseListItem(
    val title: String,
    val stars: Int,
    val unlocked: Boolean,
    val onClick: () -> Unit
)

data class ExerciseSelected(val exerciseDefinitionId: String) : Action
