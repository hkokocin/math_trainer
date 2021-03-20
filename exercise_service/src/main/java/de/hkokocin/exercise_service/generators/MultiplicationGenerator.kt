package de.hkokocin.exercise_service.generators

import de.hkokocin.exercise_service.Problem
import de.hkokocin.exercise_service.ProblemDefinition
import kotlin.math.max
import kotlin.math.min
import kotlin.random.Random

class MultiplicationGenerator(
    private val optionsGenerator: OptionsGenerator,
    private val random: Random
) {
    fun create(definition: ProblemDefinition.Numeric.Multiplication): Problem {
        val a = random.nextInt(definition.secondFactorMin, definition.secondFactorMax + 1)
        val solution = a * definition.factor

        return Problem(
            "$a * ${definition.factor}",
            solution,
            optionsGenerator.generateOptionsByFactor(definition.factor, a, 10),
            definition.score
        )
    }
}
