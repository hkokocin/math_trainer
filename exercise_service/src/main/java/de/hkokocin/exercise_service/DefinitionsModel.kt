package de.hkokocin.exercise_service

sealed class ProblemDefinition {

    abstract val score: Int

    data class Addition(
        override val score: Int,
        val maximumValue: Int
    ): ProblemDefinition()

    data class Subtraction(
        override val score: Int,
        val maximumValue: Int
    ): ProblemDefinition()

    data class Multiplication(
        override val score: Int,
        val factor: Int
    ): ProblemDefinition()
}

data class ExerciseDefinition(
    val id: String,
    val duration: Int,
    val problems: List<ProblemDefinition>,
    val performanceTiers: List<Int>,
    val title: String,
    val description: String
)

fun ExerciseDefinition.calculateStars(score: Int) = performanceTiers.count { it <= score }
