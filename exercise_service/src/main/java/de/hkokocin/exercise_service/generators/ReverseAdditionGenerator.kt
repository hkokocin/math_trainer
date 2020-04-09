package de.hkokocin.exercise_service.generators

import de.hkokocin.exercise_service.Problem
import de.hkokocin.exercise_service.ProblemDefinition
import kotlin.random.Random

class ReverseAdditionGenerator(
    private val optionsGenerator: OptionsGenerator,
    private val random: Random
) {
    fun create(definition: ProblemDefinition.ReverseAddition): Problem {
        val equationSolution = random.nextInt(definition.minimumValue + 2, definition.maximumValue + 1)
        val a = random.nextInt(definition.minimumValue + 1, equationSolution)
        val b = equationSolution - a

        val firstSummand = random.nextBoolean()
        val problemSolution = if(firstSummand) a else b

        return Problem(
            if(firstSummand) "_ + $b = $equationSolution" else "$a + _ = $equationSolution",
            problemSolution,
            optionsGenerator.generateOptions(definition.maximumValue, problemSolution),
            definition.score
        )
    }
}
