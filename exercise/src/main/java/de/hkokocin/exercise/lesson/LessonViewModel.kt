package de.hkokocin.exercise.lesson

import de.hkokocin.android.startActivity
import de.hkokocin.exercise.exercise.ExerciseActivity
import de.hkokocin.exercise.lesson.LessonViewState.ExecuteCommand
import de.hkokocin.exercise.lesson.LessonViewState.UpdateExercises
import de.hkokocin.redukt.Action
import de.hkokocin.redukt.CompositeViewModel
import de.hkokocin.redukt.ViewModelShard
import de.hkokocin.toolkit.coroutines.Jobs

class LessonViewModel(
    lessonViewModelShard: LessonViewModelShard
) : CompositeViewModel<LessonViewState>(
    lessonViewModelShard
)

class LessonViewModelShard(
    private val jobs: Jobs,
    private val loadExerciseListUseCase: LoadExerciseListUseCase
) : ViewModelShard<LessonViewState>() {

    override fun dispatch(action: Action) {
        when (action) {
            is ACTIVITY_RESUMED -> loadExercises()
            is ExerciseSelected -> openExercise(action.exerciseDefinitionId)
        }
    }

    private fun loadExercises() = jobs.launch {
        val exercises = loadExerciseListUseCase.adopt(::dispatch)
        emit(UpdateExercises(exercises))
    }

    private fun openExercise(exerciseDefinitionId: String) {
        val command = startActivity<ExerciseActivity>{
            putExtra(ExerciseActivity.EXTRA.EXERCISE_DEFINITION_ID, exerciseDefinitionId)
        }

        emit(ExecuteCommand(command))
    }

    override fun onCleared() = jobs.clear()
}
