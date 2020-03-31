package de.hkokocin.exercise_service.generators

import de.hkokocin.exercise_service.Problem
import de.hkokocin.exercise_service.ProblemDefinition
import kotlin.random.Random

class SubstractionGenerator(
    private val optionsGenerator: OptionsGenerator
) {
    fun create(definition: ProblemDefinition.Subtraction): Problem {
        val maximum = definition.maximumValue
        val solution = Random.nextInt(1, maximum)
        val a = if(solution == maximum - 1) maximum else Random.nextInt(solution, maximum) + 1
        val b = a - solution

        return Problem(
            "$a - $b",
            solution,
            optionsGenerator.generateOptions(maximum, solution),
            definition.score
        )
    }
}
