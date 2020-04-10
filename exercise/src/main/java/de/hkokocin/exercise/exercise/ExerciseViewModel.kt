package de.hkokocin.exercise.exercise

import de.hkokocin.exercise.exercise.ExerciseViewState.*
import de.hkokocin.exercise_service.ExercisesRepository
import de.hkokocin.exercise_service.Problem
import de.hkokocin.exercise_service.generators.Exercise
import de.hkokocin.local_data.LocalScoreRepository
import de.hkokocin.redukt.Action
import de.hkokocin.redukt.CompositeViewModel
import de.hkokocin.redukt.ViewModelShard
import de.hkokocin.toolkit.coroutines.Jobs

class ExerciseViewModel(
    exerciseShard: ExerciseViewModelShard
) : CompositeViewModel<ExerciseViewState>(exerciseShard)

class ExerciseViewModelShard(
    private val exercisesRepository: ExercisesRepository,
    private val scoreRepository: LocalScoreRepository,
    private val jobs: Jobs
) : ViewModelShard<ExerciseViewState>() {

    private lateinit var exerciseDefinitionId: String
    private lateinit var exercise: Exercise

    override fun dispatch(action: Action) {
        when (action) {
            is InitializeExercise -> initializeExercise(action.exerciseDefinitionId)
            is StartExercise -> startExercise()
            is SelectOption -> optionSelected(action.solutionIndex)
        }
    }

    override fun onCleared() = jobs.clear()

    private fun initializeExercise(definitionId: String) = jobs.launch {
        exerciseDefinitionId = definitionId
        exercise = exercisesRepository.createExercise(definitionId)
        val exerciseDefinition = exercisesRepository.getExercise(definitionId)
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
        emitProblem(exercise.nextProblem())
        runExercise()
    }

    private fun runExercise() = jobs.launch {
        val result = exercise.run().await()
        val oldHighscore = scoreRepository.getHighscore(exerciseDefinitionId)

        emit(Result(result.score, result.stars, result.score > oldHighscore))

        scoreRepository.updateHighscore(exerciseDefinitionId, result.score)
    }

    private fun optionSelected(solutionIndex: Int) {
        val correct = exercise.solve(solutionIndex)
        val animation = if (correct) NewProblem.Animate.SUCCESS else NewProblem.Animate.ERROR
        emitProblem(exercise.nextProblem(), animation)
    }

    private fun emitProblem(problem: Problem, animation: NewProblem.Animate = NewProblem.Animate.START) {
        val newProblem = NewProblem(
            problem.problem,
            problem.options[0].toString(),
            problem.options[1].toString(),
            problem.options[2].toString(),
            animation
        )

        emit(newProblem)
    }
}
