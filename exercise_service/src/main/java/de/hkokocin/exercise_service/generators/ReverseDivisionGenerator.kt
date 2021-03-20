package de.hkokocin.exercise_service.generators

import de.hkokocin.exercise_service.Problem
import de.hkokocin.exercise_service.ProblemDefinition
import kotlin.random.Random

class ReverseDivisionGenerator(
    private val optionsGenerator: OptionsGenerator,
    private val random: Random
) {
    fun create(definition: ProblemDefinition.Numeric.Division): Problem {
        val solution = random.nextInt(definition.solutionMin, definition.solutionMax + 1)
        val dividend = solution * definition.divisor

        return Problem(
            "_ : ${definition.divisor} = $solution",
            dividend,
            optionsGenerator.generateOptionsByFactor(definition.divisor, dividend, definition.solutionMax / definition.divisor),
            definition.score
        )
    }
}
