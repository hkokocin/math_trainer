package de.hkokocin.exercise_service.generators

import de.hkokocin.exercise_service.Problem
import de.hkokocin.exercise_service.ProblemDefinition
import kotlin.math.max
import kotlin.math.min
import kotlin.random.Random

class AdditionGenerator(
    private val optionsGenerator: OptionsGenerator,
    private val random: Random
) {
    fun create(definition: ProblemDefinition.Addition): Problem {
        val solution = random.nextInt(2, definition.maximumValue + 1)
        val a = random.nextInt(1, solution)
        val b = solution - a

        return Problem(
            "$a + $b",
            solution,
            optionsGenerator.generateOptions(definition.maximumValue, solution),
            definition.score
        )
    }
}
