package de.hkokocin.exercise_service.generators

import de.hkokocin.exercise_service.Problem
import de.hkokocin.exercise_service.ProblemDefinition
import kotlin.math.max
import kotlin.math.min
import kotlin.random.Random

class MultiplicationGenerator(
    private val optionsGenerator: OptionsGenerator
) {
    fun create(definition: ProblemDefinition.Multiplication): Problem {
        val a = Random.nextInt(1, 10)
        val solution = a * definition.factor

        return Problem(
            "${definition.factor} * $a",
            solution,
            optionsGenerator.generateOptionsByFactor(definition.factor, a, 10),
            definition.score
        )
    }
}
