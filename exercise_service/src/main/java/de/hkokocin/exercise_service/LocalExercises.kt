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

val MULTIPLICATIONS = (1..10).map {
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
    ADD_5, ADD_10, ADD_20, ADD_100,
    SUB_5, SUB_10, SUB_20, SUB_100,
    *MULTIPLICATIONS.toTypedArray()
)

// ==============================================================================
// LESSONS
// ==============================================================================

val ADDITION_1 = LessonDefinition(
    "ADDITION_1",
    "Addition 1",
    "",
    listOf(ADD_5, ADD_10)
)

val SUBTRACTION_1 = LessonDefinition(
    "SUBTRACTION_1",
    "Subtraktion 1",
    "",
    listOf(SUB_5, SUB_10)
)

val ADDITION_2 = LessonDefinition(
    "ADDITION_2",
    "Addition 2",
    "",
    listOf(ADD_20)
)

val SUBTRACTION_2 = LessonDefinition(
    "SUBTRACTION_2",
    "Subtraktion 2",
    "",
    listOf(SUB_20)
)


val ADDITION_3 = LessonDefinition(
    "ADDITION_3",
    "Addition 3",
    "",
    listOf(ADD_100)
)

val SUBTRACTION_3 = LessonDefinition(
    "SUBTRACTION_3",
    "Subtraktion 3",
    "",
    listOf(SUB_100)
)

val ADDITION_SUBTRACTION_1 = LessonDefinition(
    "ADDITION_SUBTRACTION_1",
    "Addition und Subtraktion bis 100",
    "",
    listOf(ADD_SUB_20)
)

val ADDITION_SUBTRACTION_2 = LessonDefinition(
    "ADDITION_SUBTRACTION_2",
    "Addition und Subtraktion bis 100",
    "",
    listOf(ADD_SUB_100)
)

val MULTIPLICATION_1 = LessonDefinition(
    "MULTIPLICATION_1",
    "Multiplikation 1",
    "",
    listOf(MULTIPLICATIONS[0], MULTIPLICATIONS[9])
)

val MULTIPLICATION_2 = LessonDefinition(
    "MULTIPLICATION_2",
    "Multiplikation 2",
    "",
    listOf(MULTIPLICATIONS[4], MULTIPLICATIONS[1], MULTIPLICATIONS[8])
)

val MULTIPLICATION_3 = LessonDefinition(
    "MULTIPLICATION_3",
    "Multiplikation 3",
    "",
    listOf(MULTIPLICATIONS[2], MULTIPLICATIONS[3], MULTIPLICATIONS[5], MULTIPLICATIONS[7], MULTIPLICATIONS[6])
)

val ALL_LOCAL_LESSONS = listOf(
    ADDITION_1, ADDITION_2, ADDITION_3,
    SUBTRACTION_1, SUBTRACTION_2, SUBTRACTION_3,
    ADDITION_SUBTRACTION_1, ADDITION_SUBTRACTION_2,
    MULTIPLICATION_1, MULTIPLICATION_2, MULTIPLICATION_3
)

val ALL_LOCAL_GRADES = listOf(
    GradeDefinition(0, "ADDITION_1", "SUBTRACTION_1"),
    GradeDefinition(1, "ADDITION_2", "SUBTRACTION_2"),
    GradeDefinition(2, "ADDITION_3", "SUBTRACTION_3", "MULTIPLICATION_1"),
    GradeDefinition(3, multiplyLessonId = "MULTIPLICATION_2"),
    GradeDefinition(4, multiplyLessonId = "MULTIPLICATION_3")
)
