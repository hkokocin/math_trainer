package de.hkokocin.exercise_service.generators

import kotlin.math.max
import kotlin.math.min
import kotlin.random.Random

const val CHOICES_THRESHOLD = 2

class OptionsGenerator {

    fun generateOptions(maximumValue: Int, solution: Int): List<Int> {
        val from = max(0, solution - CHOICES_THRESHOLD)

        val to = if (from == 0) min(2 * CHOICES_THRESHOLD, maximumValue)
        else min(solution + CHOICES_THRESHOLD, maximumValue)

        val choices = mutableSetOf(solution)

        while (choices.size < 3)
            choices.add(Random.nextInt(from, to))

        return choices.toList().sorted()
    }

    fun generateOptionsByFactor(fixFactor: Int, variableFactor: Int, maximumFactor: Int): List<Int> {
        val from = max(0, variableFactor - CHOICES_THRESHOLD)

        val to = if (from == 0) min(2 * CHOICES_THRESHOLD, maximumFactor)
        else min(variableFactor + CHOICES_THRESHOLD, maximumFactor)

        val choices = mutableSetOf(fixFactor * variableFactor)

        while (choices.size < 3)
            choices.add(Random.nextInt(from, to) * fixFactor)

        return choices.toList().shuffled()
    }
}
