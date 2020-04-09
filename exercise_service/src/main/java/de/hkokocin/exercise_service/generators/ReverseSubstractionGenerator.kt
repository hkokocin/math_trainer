package de.hkokocin.exercise_service.generators

import de.hkokocin.exercise_service.Problem
import de.hkokocin.exercise_service.ProblemDefinition
import kotlin.random.Random

class ReverseSubstractionGenerator(
    private val optionsGenerator: OptionsGenerator,
    private val random: Random
) {
    fun create(definition: ProblemDefinition.ReverseSubtraction): Problem {
        val maximum = definition.maximumValue
        val equationSolution = random.nextInt(definition.minimumValue + 1, maximum)
        val a = if (equationSolution == maximum - 1) maximum else random.nextInt(equationSolution, maximum) + 1
        val b = a - equationSolution

        val subtracted = random.nextBoolean()
        val problemSolution = if (subtracted) a else b

        return Problem(
            if (subtracted) "_ - $b = $equationSolution" else "$a - _ = $equationSolution",
            problemSolution,
            optionsGenerator.generateOptions(maximum, problemSolution),
            definition.score
        )
    }
}
