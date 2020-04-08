package de.hkokocin.exercise.grade

import de.hkokocin.android.startActivity
import de.hkokocin.exercise.grade.GradeViewState.UpdateGrades
import de.hkokocin.exercise.lesson.LessonActivity
import de.hkokocin.exercise_service.*
import de.hkokocin.local_data.LocalScoreRepository
import de.hkokocin.redukt.Action
import de.hkokocin.redukt.CompositeViewModel
import de.hkokocin.redukt.ViewModelShard
import de.hkokocin.toolkit.coroutines.Jobs

class GradeTreeViewModel(shard: GradeTreeViewModelShard) : CompositeViewModel<GradeViewState>(shard)

class GradeTreeViewModelShard(
    private val loadGradesUseCase: LoadGradesUseCase,
    private val jobs: Jobs
) : ViewModelShard<GradeViewState>() {

    override fun dispatch(action: Action) {
        when (action) {
            is ViewCreated -> loadGrades()
        }
    }

    private fun loadGrades() = jobs.launch {
        val gradeRows = loadGradesUseCase.adopt(::emit)
        emit(UpdateGrades(gradeRows))
    }

    override fun onCleared() {
        super.onCleared()
        jobs.clear()
    }
}



