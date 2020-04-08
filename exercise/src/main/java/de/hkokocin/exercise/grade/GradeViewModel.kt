package de.hkokocin.exercise.grade

import de.hkokocin.exercise.grade.GradeViewState.UpdateGrades
import de.hkokocin.redukt.Action
import de.hkokocin.redukt.CompositeViewModel
import de.hkokocin.redukt.ViewModelShard
import de.hkokocin.toolkit.coroutines.Jobs

class GradeViewModel(shard: GradeViewModelShard) : CompositeViewModel<GradeViewState>(shard)

class GradeViewModelShard(
    private val loadGradesUseCase: LoadGradesUseCase,
    private val jobs: Jobs
) : ViewModelShard<GradeViewState>() {

    override fun dispatch(action: Action) {
        when (action) {
            is ViewResumed -> loadGrades()
        }
    }

    private fun loadGrades() = jobs.launch {
        emit(UpdateGrades(loadGradesUseCase.adopt(::emit)))
    }

    override fun onCleared() {
        super.onCleared()
        jobs.clear()
    }
}



