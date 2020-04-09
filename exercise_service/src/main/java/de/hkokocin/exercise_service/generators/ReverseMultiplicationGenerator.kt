package de.hkokocin.exercise_service.generators

import de.hkokocin.exercise_service.Problem
import de.hkokocin.exercise_service.ProblemDefinition
import kotlin.random.Random

class ReverseMultiplicationGenerator(
    private val optionsGenerator: OptionsGenerator,
    private val random: Random
) {
    fun create(definition: ProblemDefinition.ReverseMultiplication): Problem {
        val a = random.nextInt(definition.secondFactorMin, definition.secondFactorMax + 1)
        val b = definition.factor
        val equationSolution = a * b

        return Problem(
            "_ * $b = $equationSolution",
            a,
            optionsGenerator.generateOptions(definition.secondFactorMax + 1, a),
            definition.score
        )
    }
}
