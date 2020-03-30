package de.hkokocin.exercise_service

val ADD_10 = ExerciseDefinition(
    "ADD_10",
    60,
    listOf(ProblemDefinition.Addition(1, 10)),
    listOf(8, 16, 24),
    "Addition bis 10",
    ""
)

val ADD_20 = ExerciseDefinition(
    "ADD_20",
    60,
    listOf(ProblemDefinition.Addition(1, 20)),
    listOf(8, 16, 24),
    "Addition bis 20",
    ""
)

val ADD_100 = ExerciseDefinition(
    "ADD_100",
    60,
    listOf(ProblemDefinition.Addition(1, 100)),
    listOf(5, 10, 15),
    "Addition bis 100",
    ""
)

val SUB_10 = ExerciseDefinition(
    "SUB_10",
    60,
    listOf(ProblemDefinition.Subtraction(1, 10)),
    listOf(8, 16, 24),
    "Subtraktion bis 10",
    ""
)

val SUB_20 = ExerciseDefinition(
    "SUB_20",
    60,
    listOf(ProblemDefinition.Subtraction(1, 20)),
    listOf(8, 16, 24),
    "Subtraktion bis 20",
    ""
)

val SUB_100 = ExerciseDefinition(
    "SUB_100",
    60,
    listOf(ProblemDefinition.Subtraction(1, 100)),
    listOf(5, 10, 15),
    "Subtraktion bis 100",
    ""
)

val MULTIPLICATIONS = (2..10).map {
    ExerciseDefinition(
        "MULTIPLICATION_$it",
        60,
        listOf(ProblemDefinition.Multiplication(1, it)),
        listOf(6, 12, 18),
        "Multiplikation mit $it",
        ""
    )
}

val ALL_LOCAL_EXERCISES = listOf(
    ADD_10, ADD_20, ADD_100,
    SUB_10, SUB_20, SUB_100,
    *MULTIPLICATIONS.toTypedArray()
)
