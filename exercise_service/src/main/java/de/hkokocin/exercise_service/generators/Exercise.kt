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

class Exercise(
    private val definition: ExerciseDefinition,
    private val problemGenerator: ProblemGenerator
) {
    private var currentProblem: Problem? = null

    private val solutions = mutableMapOf<Problem, Int>()

    val duration = definition.duration
    val title = definition.title
    val description = definition.description

    var finished = false
        private set

    suspend fun run(): Deferred<ExerciseResult> = scopeAsync {
        delay(definition.duration * 1000L)
        finished = true

        val errorCount = solutions.filter { it.key.solution != it.value }.size
        val score = solutions
            .filter { it.key.solution == it.value }
            .map { it.key.score }
            .sum()
            .minus(errorCount)

        val stars = definition.calculateStars(score)

        ExerciseResult(score, stars)
    }

    fun solve(solutionIndex: Int): Boolean {
        check(!finished) { "Exercise has already been finished" }
        val problem = checkNotNull(currentProblem) { "Exercise has not been started" }

        solutions[problem] = problem.options[solutionIndex]

        return problem.solution == problem.options[solutionIndex]
    }

    fun nextProblem() = problemGenerator
        .create(definition.problems)
        .also { currentProblem = it }
}
