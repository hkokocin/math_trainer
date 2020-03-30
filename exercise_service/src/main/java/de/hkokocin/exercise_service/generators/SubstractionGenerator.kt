package de.hkokocin.exercise_service.generators

import de.hkokocin.exercise_service.Problem
import de.hkokocin.exercise_service.ProblemDefinition
import kotlin.random.Random

class SubstractionGenerator(
    private val optionsGenerator: OptionsGenerator
) {
    fun create(definition: ProblemDefinition.Subtraction): Problem {
        val solution = Random.nextInt(1, definition.maximumValue)
        val a = Random.nextInt(solution + 1, definition.maximumValue)
        val b = a - solution

        return Problem(
            "$a - $b",
            solution,
            optionsGenerator.generateOptions(definition.maximumValue, solution),
            definition.score
        )
    }
}
