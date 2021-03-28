package de.hkokocin.exercise.grade.ui

import de.hkokocin.android.startActivity
import de.hkokocin.exercise.exercise.ExerciseActivity
import de.hkokocin.exercise.grade.domain.LoadGradeUseCase
import de.hkokocin.exercise_service.grade.Arithmetic
import de.hkokocin.redukt.Action
import de.hkokocin.redukt.LifecycleOnDestroy
import de.hkokocin.redukt.LifecycleOnResume
import de.hkokocin.redukt.ObservableViewModel
import de.hkokocin.toolkit.coroutines.Jobs

class GradeViewModel(
    private val jobs: Jobs,
    private val loadGrade: LoadGradeUseCase,
    private val arithmetic: Arithmetic
) : ObservableViewModel<GradeViewState>() {

    override fun dispatch(action: Action) {
        when (action) {
            is LifecycleOnResume -> loadGrades()
            is LifecycleOnDestroy -> jobs.clear()
            is ExerciseSelected -> openExercise(action.exerciseDefinitionId)
        }
    }

    private fun loadGrades() = jobs.launch {
        val grade = loadGrade.adopt(arithmetic)

        val exerciseItems = grade.exercises.map {
            ExerciseListItem(
                it.title,
                it.stars,
                it.unlocked,
                { openExercise(it.exerciseDefinitionId) }
            )
        }

        emit(GradeViewState.Data(grade, exerciseItems))
    }

    private fun openExercise(exerciseDefinitionId: String) {
        val command = startActivity<ExerciseActivity> {
            putExtra(ExerciseActivity.EXTRA.EXERCISE_DEFINITION_ID, exerciseDefinitionId)
        }

        emit(GradeViewState.Command(command))
    }
}
