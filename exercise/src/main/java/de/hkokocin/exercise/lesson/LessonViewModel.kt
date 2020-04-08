package de.hkokocin.exercise.lesson

import de.hkokocin.android.startActivity
import de.hkokocin.exercise.R
import de.hkokocin.exercise.exercise.ExerciseActivity
import de.hkokocin.exercise.lesson.LessonViewState.*
import de.hkokocin.exercise_service.ExercisesRepository
import de.hkokocin.exercise_service.ProblemDefinition
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
    private val loadExerciseListUseCase: LoadExerciseListUseCase,
    private val exercisesRepository: ExercisesRepository
) : ViewModelShard<LessonViewState>() {

    override fun dispatch(action: Action) {
        when (action) {
            is ActivityResumed -> loadData(action.lessonId)
            is ExerciseSelected -> openExercise(action.exerciseDefinitionId)
        }
    }

    private fun loadData(lessonId: String) = jobs.launch {
        val lesson = exercisesRepository.getLesson(lessonId)

        emit(UpdateLesson(lesson.title))

        loadExercises(lessonId)
    }

    private suspend fun loadExercises(lessonId: String) {
        val exercises = loadExerciseListUseCase.adopt(lessonId, ::dispatch)
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
