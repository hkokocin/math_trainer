package de.hkokocin.exercise.grade

import de.blox.graphview.Graph
import de.hkokocin.android.ActivityCommand
import de.hkokocin.redukt.Action
import de.hkokocin.redukt.ViewState

sealed class GradeTreeViewState : ViewState {
    data class UpdateGraph(val graph: Graph) : GradeTreeViewState()
    data class Command(val command: ActivityCommand) : GradeTreeViewState()
}

data class LessonNodeViewState(
    val title: String,
    val stars: Int,
    val onClick: () -> Unit
)

object ViewCreated : Action
