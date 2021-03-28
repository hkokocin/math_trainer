package de.hkokocin.exercise.exercise

import de.hkokocin.exercise.exercise.ExerciseViewState.*
import de.hkokocin.exercise_service.DefinitionsRepository
import de.hkokocin.exercise_service.generators.Exercise
import de.hkokocin.exercise_service.generators.Solution
import de.hkokocin.local_data.LocalScoreRepository
import de.hkokocin.redukt.Action
import de.hkokocin.redukt.LifecycleOnDestroy
import de.hkokocin.redukt.LifecycleOnStart
import de.hkokocin.redukt.ObservableViewModel
import de.hkokocin.toolkit.coroutines.Jobs

class ExerciseViewModel(
    private val definitionsRepository: DefinitionsRepository,
    private val scoreRepository: LocalScoreRepository,
    private val jobs: Jobs
) : ObservableViewModel<ExerciseViewState>() {

    private lateinit var exerciseDefinitionId: String
    private lateinit var exercise: Exercise

    override fun dispatch(action: Action) {
        when (action) {
            is InitializeExercise -> initializeExercise(action.exerciseDefinitionId)
            is StartExercise -> startExercise()
            is SelectOption -> optionSelected(action.solutionIndex)
            is LifecycleOnDestroy -> jobs.clear()
        }
    }

    private fun initializeExercise(definitionId: String) = jobs.launch {
        exerciseDefinitionId = definitionId
        exercise = definitionsRepository.createExercise(definitionId)
        val exerciseDefinition = definitionsRepository.getExercise(definitionId)
        val state = Initialization(
            exercise.title,
            exercise.description,
            scoreRepository.getHighscore(exerciseDefinitionId),
            exerciseDefinition.performanceTiers[0],
            exerciseDefinition.performanceTiers[1],
            exerciseDefinition.performanceTiers[2]
        )
        emit(state)
    }

    private fun startExercise() {
        emit(Start(exercise.duration))
        emitNextProblem()
        runExercise()
    }

    private fun runExercise() = jobs.launch {
        val result = exercise.run().await()
        val oldHighscore = scoreRepository.getHighscore(exerciseDefinitionId)

        emit(Result(result.score, result.stars, result.score > oldHighscore))

        scoreRepository.updateHighscore(exerciseDefinitionId, result.score)
    }

    private fun optionSelected(solutionIndex: Int) {
        val solution = exercise.solveCurrentProblem(solutionIndex)
        when(solution){
            is Solution.Correct -> emitNextProblem(NewProblem.Animate.SUCCESS, null)
            is Solution.Wrong -> emitNextProblem(NewProblem.Animate.ERROR, solution.correctSolution)
        }
    }

    private fun emitNextProblem(
        animation: NewProblem.Animate = NewProblem.Animate.START,
        previousSolution: Int? = null
    ) {
        val problem = exercise.nextProblem()

        val newProblem = NewProblem(
            problem.problem,
            problem.options[0].toString(),
            problem.options[1].toString(),
            problem.options[2].toString(),
            animation,
            previousSolution?.toString()
        )

        emit(newProblem)
    }
}
