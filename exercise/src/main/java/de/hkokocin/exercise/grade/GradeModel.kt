package de.hkokocin.exercise.grade

import de.hkokocin.android.ActivityCommand
import de.hkokocin.redukt.Action
import de.hkokocin.redukt.ViewState

sealed class GradeViewState : ViewState {
    data class UpdateGrades(val grades: List<GradeViewPageState>) : GradeViewState()
    data class Command(val command: ActivityCommand) : GradeViewState()
}

data class GradeViewPageState(
    val index: Int,
    val starsCollected: Int,
    val starsRemaining: Int,
    val starsToNextLevel: Int,
    val unlocked: Boolean,
    val addLesson: LessonState?,
    val subtractLesson: LessonState?,
    val multiplyLesson: LessonState?,
    val divideLesson: LessonState?
)

data class LessonState(
    val title: String,
    val progressStars: Int,
    val totalStars: Int,
    val showTrackToItem: Boolean,
    val showTrackFromItem: Boolean,
    val onClick: () -> Unit
)

data class GradeProgressWidgetState(
    val totalStars: Int,
    val progressStars: Int,
    val unlocked: Boolean
)

object ViewResumed : Action
