package de.hkokocin.exercise_service.generators

import de.hkokocin.exercise_service.ExerciseDefinition
import de.hkokocin.exercise_service.Problem
import de.hkokocin.exercise_service.calculateStars
import de.hkokocin.toolkit.coroutines.scopeAsync
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.delay

data class ExerciseResult(
    val score: Int,
    val stars: Int
)

data class ProblemResult(
    val problem: Problem,
    val solutionIndex: Int
)

sealed class Solution{
    class Correct: Solution()
    data class Wrong(val correctSolution: Int): Solution()
}

class Exercise(
    private val definition: ExerciseDefinition,
    private val problemGenerator: ProblemGenerator
) {
    private var currentProblem: Problem? = null
    var result: ExerciseResult? = null

    private val solutions = mutableListOf<ProblemResult>()

    val duration = definition.duration
    val title = definition.title
    val description = definition.description

    var finished = false
        private set

    suspend fun run(): Deferred<ExerciseResult> = scopeAsync {
        delay(definition.duration * 1000L)
        finished = true

        val errorCount = solutions.filter { it.problem.solution != it.solutionIndex }.size
        val score = solutions
            .filter { it.problem.solution == it.solutionIndex }
            .map { it.problem.score }
            .sum()
            .minus(errorCount)

        val stars = definition.calculateStars(score)

        ExerciseResult(score, stars).also { result = it }
    }

    fun solveCurrentProblem(solutionIndex: Int): Solution {
        check(!finished) { "Exercise has already been finished" }
        val problem = checkNotNull(currentProblem) { "Exercise has not been started" }

        solutions.add(ProblemResult(problem, problem.options[solutionIndex]))

        val correct = problem.solution == problem.options[solutionIndex]

        return if(correct) Solution.Correct() else Solution.Wrong(problem.solution)
    }

    fun nextProblem() = problemGenerator
        .create(definition.problems)
        .also { currentProblem = it }
}
