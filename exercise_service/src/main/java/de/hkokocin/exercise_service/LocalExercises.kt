package de.hkokocin.exercise_service

// ==============================================================================
// EXERCISES
// ==============================================================================

val ADD_5 = ExerciseDefinition(
    "ADD_5",
    60,
    listOf(ProblemDefinition.Addition(1, 5)),
    listOf(8, 16, 22),
    "Addition bis 5",
    ""
)

val ADD_10 = ExerciseDefinition(
    "ADD_10",
    60,
    listOf(ProblemDefinition.Addition(1, 10)),
    listOf(8, 16, 22),
    "Addition bis 10",
    ""
)

val ADD_20 = ExerciseDefinition(
    "ADD_20",
    60,
    listOf(ProblemDefinition.Addition(1, 20)),
    listOf(7, 14, 20),
    "Addition bis 20",
    ""
)

val ADD_100 = ExerciseDefinition(
    "ADD_100",
    60,
    listOf(ProblemDefinition.Addition(1, 100)),
    listOf(5, 10, 14),
    "Addition bis 100",
    ""
)

val SUB_10 = ExerciseDefinition(
    "SUB_10",
    60,
    listOf(ProblemDefinition.Subtraction(1, 10)),
    listOf(8, 16, 22),
    "Subtraktion bis 10",
    ""
)

val SUB_5 = ExerciseDefinition(
    "SUB_5",
    60,
    listOf(ProblemDefinition.Subtraction(1, 5)),
    listOf(8, 16, 22),
    "Subtraktion bis 5",
    ""
)

val SUB_20 = ExerciseDefinition(
    "SUB_20",
    60,
    listOf(ProblemDefinition.Subtraction(1, 20)),
    listOf(7, 14, 20),
    "Subtraktion bis 20",
    ""
)

val SUB_100 = ExerciseDefinition(
    "SUB_100",
    60,
    listOf(ProblemDefinition.Subtraction(1, 100)),
    listOf(5, 10, 14),
    "Subtraktion bis 100",
    ""
)

val ADD_SUB_20 = ExerciseDefinition(
    "SUB_20",
    60,
    listOf(ProblemDefinition.Addition(1, 20), ProblemDefinition.Subtraction(1, 20)),
    listOf(7, 14, 20),
    "Addition und Subtraktion bis 20",
    ""
)

val ADD_SUB_100 = ExerciseDefinition(
    "SUB_100",
    60,
    listOf(ProblemDefinition.Addition(1, 100), ProblemDefinition.Subtraction(1, 100)),
    listOf(7, 14, 20),
    "Addition und Subtraktion bis 100",
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

// ==============================================================================
// LESSONS
// ==============================================================================

val TUTORIAL = LessonDefinition(
    "TUTORIAL",
    "Einführung",
    "",
    listOf(ADD_5),
    emptyList()
)

val ADDITION_1 = LessonDefinition(
    "ADDITION_1",
    "Addition Level 1",
    "",
    listOf(ADD_5, ADD_10, ADD_20),
    listOf("TUTORIAL")
)

val SUBTRACTION_1 = LessonDefinition(
    "SUBTRACTION_1",
    "Subtraktion Level 1",
    "",
    listOf(SUB_5, SUB_10, SUB_20),
    listOf("TUTORIAL")
)

val ADDITION_SUBTRACTION_1 = LessonDefinition(
    "ADDITION_SUBTRACTION_1",
    "Addition und Subtraktion bis 100",
    "",
    listOf(ADD_SUB_20, ADD_100, SUB_100, ADD_SUB_100),
    listOf("ADDITION_1", "SUBTRACTION_1")
)

val ALL_LOCAL_LESSONS = listOf(TUTORIAL, ADDITION_1, SUBTRACTION_1, ADDITION_SUBTRACTION_1)
