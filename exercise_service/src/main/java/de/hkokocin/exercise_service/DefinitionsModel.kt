package de.hkokocin.exercise_service

const val MAX_STARS = 3
const val UNLOCK_GRADE_STAR_RATIO = 0.67f

sealed class ProblemDefinition {

    abstract val score: Int

    sealed class Numeric : ProblemDefinition() {

        data class Addition(
            override val score: Int,
            val minimumValue: Int,
            val maximumValue: Int
        ) : ProblemDefinition()

        data class Subtraction(
            override val score: Int,
            val minimumValue: Int,
            val maximumValue: Int
        ) : ProblemDefinition()

        data class Multiplication(
            override val score: Int,
            val factor: Int,
            val secondFactorMin: Int,
            val secondFactorMax: Int
        ) : ProblemDefinition()

        data class Division(
            override val score: Int,
            val divisor: Int,
            val solutionMin: Int,
            val solutionMax: Int
        ) : ProblemDefinition()

        data class ReverseAddition(
            override val score: Int,
            val minimumValue: Int,
            val maximumValue: Int
        ) : ProblemDefinition()

        data class ReverseSubtraction(
            override val score: Int,
            val minimumValue: Int,
            val maximumValue: Int
        ) : ProblemDefinition()

        data class ReverseMultiplication(
            override val score: Int,
            val factor: Int,
            val secondFactorMin: Int,
            val secondFactorMax: Int
        ) : ProblemDefinition()
    }

    data class ReverseDivision(
        override val score: Int,
        val divisor: Int,
        val solutionMin: Int,
        val solutionMax: Int
    ) : ProblemDefinition()
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

