package de.hkokocin.exercise.exercise

import de.hkokocin.redukt.Action
import de.hkokocin.redukt.ViewState

sealed class ExerciseViewState : ViewState {

    data class NewProblem(
        val problem: String,
        val option1: String,
        val option2: String,
        val option3: String,
        val animate: Animate
    ) : ExerciseViewState() {
        enum class Animate { START, ERROR, SUCCESS }
    }

    data class Start(
        val duration: Int
    ) : ExerciseViewState()

    data class Initialization(
        val title: String,
        val description: String,
        val highscore: Int
    ) : ExerciseViewState()

    data class Result(
        val score: Int,
        val stars: Int
    ) : ExerciseViewState()
}

internal data class InitializeExercise(val exerciseDefinitionId: String) : Action
internal object StartExercise : Action
internal data class SelectOption(val solutionIndex: Int) : Action