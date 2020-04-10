package de.hkokocin.exercise_service

private val EASY_TIERS = listOf(8, 16, 22)
private val MODERATE_TIERS = listOf(7, 14, 18)
private val HARD_TIERS = listOf(6, 10, 14)
private val X_HARD_TIERS = listOf(5, 9, 12)

private const val DEFAULT_DURATION = 5

// ==============================================================================
// EXERCISES
// ==============================================================================

// ------------------------------------------------------------------------------
// ADDITION
// ------------------------------------------------------------------------------

val ADD_5 = ExerciseDefinition(
    "ADD_5",
    DEFAULT_DURATION,
    listOf(ProblemDefinition.Addition(1, 0, 5)),
    EASY_TIERS,
    "Addition bis 5",
    ""
)

val REVERSE_ADD_5 = ExerciseDefinition(
    "REVERSE_ADD_5",
    DEFAULT_DURATION,
    listOf(ProblemDefinition.ReverseAddition(1, 0, 5)),
    MODERATE_TIERS,
    "Addition bis 5 (Umkehraufgaben)",
    ""
)

val ADD_5_10 = ExerciseDefinition(
    "ADD_10",
    DEFAULT_DURATION,
    listOf(ProblemDefinition.Addition(1, 6, 10)),
    EASY_TIERS,
    "Addition bis 10",
    ""
)

val ADD_10 = ExerciseDefinition(
    "ADD_10",
    DEFAULT_DURATION,
    listOf(ProblemDefinition.Addition(1, 0, 10)),
    EASY_TIERS,
    "Addition bis 10",
    ""
)

val REVERSE_ADD_10 = ExerciseDefinition(
    "REVERSE_ADD_10",
    DEFAULT_DURATION,
    listOf(ProblemDefinition.ReverseAddition(1, 0, 10)),
    MODERATE_TIERS,
    "Addition bis 10 (Umkehraufgaben)",
    ""
)

val COMBINED_ADD_10 = ExerciseDefinition(
    "COMBINED_ADD_10",
    DEFAULT_DURATION,
    listOf(
        ProblemDefinition.Addition(1, 0, 10),
        ProblemDefinition.ReverseAddition(1, 0, 10)
    ),
    MODERATE_TIERS,
    "Addition bis 10 (gemischt)",
    ""
)

val ADD_20 = ExerciseDefinition(
    "ADD_20",
    DEFAULT_DURATION,
    listOf(ProblemDefinition.Addition(1, 0, 20)),
    EASY_TIERS,
    "Addition bis 20",
    ""
)

val REVERSE_ADD_20 = ExerciseDefinition(
    "REVERSE_ADD_20",
    DEFAULT_DURATION,
    listOf(ProblemDefinition.ReverseAddition(1, 0, 20)),
    MODERATE_TIERS,
    "Addition bis 20 (Umkehraufgaben)",
    ""
)

val COMBINED_ADD_20 = ExerciseDefinition(
    "COMBINED_ADD_20",
    DEFAULT_DURATION,
    listOf(
        ProblemDefinition.Addition(1, 0, 20),
        ProblemDefinition.ReverseAddition(1, 0, 20)
    ),
    MODERATE_TIERS,
    "Addition bis 20 (gemischt)",
    ""
)

val ADD_100 = ExerciseDefinition(
    "ADD_100",
    DEFAULT_DURATION,
    listOf(ProblemDefinition.Addition(1, 0, 100)),
    HARD_TIERS,
    "Addition bis 100",
    ""
)

val REVERSE_ADD_100 = ExerciseDefinition(
    "REVERSE_ADD_100",
    DEFAULT_DURATION,
    listOf(ProblemDefinition.ReverseAddition(1, 0, 100)),
    X_HARD_TIERS,
    "Addition bis 100 (Umkehraufgaben)",
    ""
)

val COMBINED_ADD_100 = ExerciseDefinition(
    "COMBINED_ADD_100",
    DEFAULT_DURATION,
    listOf(
        ProblemDefinition.Addition(1, 0, 100),
        ProblemDefinition.ReverseAddition(1, 0, 100)
    ),
    X_HARD_TIERS,
    "Addition bis 100 (gemischt)",
    ""
)

// ------------------------------------------------------------------------------
// SUBTRACTION
// ------------------------------------------------------------------------------

val SUB_5 = ExerciseDefinition(
    "SUB_5",
    DEFAULT_DURATION,
    listOf(ProblemDefinition.Subtraction(1, 0, 5)),
    EASY_TIERS,
    "Subtraktion bis 5",
    ""
)

val SUB_5_10 = ExerciseDefinition(
    "SUB_5",
    DEFAULT_DURATION,
    listOf(ProblemDefinition.Subtraction(1, 6, 10)),
    EASY_TIERS,
    "Subtraktion 5 - 10",
    ""
)

val REVERSE_SUB_5 = ExerciseDefinition(
    "REVERSE_SUB_5",
    DEFAULT_DURATION,
    listOf(ProblemDefinition.ReverseSubtraction(1, 0, 5)),
    EASY_TIERS,
    "Subtraktion bis 5 (Umkehraufgaben)",
    ""
)

val SUB_10 = ExerciseDefinition(
    "SUB_10",
    DEFAULT_DURATION,
    listOf(ProblemDefinition.Subtraction(1, 0, 10)),
    EASY_TIERS,
    "Subtraktion bis 10",
    ""
)

val REVERSE_SUB_10 = ExerciseDefinition(
    "REVERSE_SUB_10",
    DEFAULT_DURATION,
    listOf(ProblemDefinition.ReverseSubtraction(1, 0, 10)),
    MODERATE_TIERS,
    "Subtraktion bis 10 (Umkehraufgaben)",
    ""
)

val COMBINED_SUB_10 = ExerciseDefinition(
    "COMBINED_SUB_10",
    DEFAULT_DURATION,
    listOf(
        ProblemDefinition.Subtraction(1, 0, 10),
        ProblemDefinition.ReverseSubtraction(1, 0, 10)
    ),
    MODERATE_TIERS,
    "Subtraktion bis 10 (Umkehraufgaben)",
    ""
)

val SUB_20 = ExerciseDefinition(
    "SUB_20",
    DEFAULT_DURATION,
    listOf(ProblemDefinition.Subtraction(1, 0, 20)),
    EASY_TIERS,
    "Subtraktion bis 20",
    ""
)

val REVERSE_SUB_20 = ExerciseDefinition(
    "REVERSE_SUB_20",
    DEFAULT_DURATION,
    listOf(ProblemDefinition.ReverseSubtraction(1, 0, 20)),
    MODERATE_TIERS,
    "Subtraktion bis 20 (Umkehraufgaben)",
    ""
)

val COMBINED_SUB_20 = ExerciseDefinition(
    "COMBINED_SUB_20",
    DEFAULT_DURATION,
    listOf(
        ProblemDefinition.Subtraction(1, 0, 20),
        ProblemDefinition.ReverseSubtraction(1, 0, 20)
    ),
    MODERATE_TIERS,
    "Subtraktion bis 20 (gemischt)",
    ""
)

val SUB_100 = ExerciseDefinition(
    "SUB_100",
    DEFAULT_DURATION,
    listOf(ProblemDefinition.Subtraction(1, 0, 100)),
    HARD_TIERS,
    "Subtraktion bis 100",
    ""
)

val REVERSE_SUB_100 = ExerciseDefinition(
    "REVERSE_SUB_100",
    DEFAULT_DURATION,
    listOf(ProblemDefinition.ReverseSubtraction(1, 0, 100)),
    X_HARD_TIERS,
    "Subtraktion bis 100 (Umkehraufgaben)",
    ""
)

val COMBINED_SUB_100 = ExerciseDefinition(
    "COMBINED_SUB_100",
    DEFAULT_DURATION,
    listOf(
        ProblemDefinition.Subtraction(1, 0, 100),
        ProblemDefinition.ReverseSubtraction(1, 0, 100)
    ),
    X_HARD_TIERS,
    "Subtraktion bis 100 (Umkehraufgaben)",
    ""
)

// ------------------------------------------------------------------------------
// MULTIPLICATIONS
// ------------------------------------------------------------------------------

val MULTIPLICATIONS = (1..10).map {
    ExerciseDefinition(
        "MULTIPLICATION_$it",
        DEFAULT_DURATION,
        listOf(ProblemDefinition.Multiplication(1, it, 1, 10)),
        MODERATE_TIERS,
        "Multiplikation mit $it",
        ""
    )
}

val MULTIPLICATIONS_LOW = (1..10).map {
    ExerciseDefinition(
        "MULTIPLICATION_LOW_$it",
        DEFAULT_DURATION,
        listOf(ProblemDefinition.Multiplication(1, it, 1, 5)),
        MODERATE_TIERS,
        "Multiplikation mit $it (1-5)",
        ""
    )
}

val MULTIPLICATIONS_HIGH = (1..10).map {
    ExerciseDefinition(
        "MULTIPLICATION_HIGH_$it",
        DEFAULT_DURATION,
        listOf(ProblemDefinition.Multiplication(1, it, 6, 10)),
        MODERATE_TIERS,
        "Multiplikation mit $it (6-10)",
        ""
    )
}

val REVERSE_MULTIPLICATIONS = (1..10).map {
    ExerciseDefinition(
        "REVERSE_MULTIPLICATION_$it",
        DEFAULT_DURATION,
        listOf(ProblemDefinition.ReverseMultiplication(1, it, 1, 10)),
        HARD_TIERS,
        "Multiplikation mit $it (Umkehraufgaben)",
        ""
    )
}

val REVERSE_MULTIPLICATIONS_LOW = (1..10).map {
    ExerciseDefinition(
        "REVERSE_LOW_MULTIPLICATION_$it",
        DEFAULT_DURATION,
        listOf(ProblemDefinition.ReverseMultiplication(1, it, 1, 5)),
        MODERATE_TIERS,
        "Multiplikation mit $it (1-5, Umkehraufgaben)",
        ""
    )
}

val REVERSE_MULTIPLICATIONS_HIGH = (1..10).map {
    ExerciseDefinition(
        "REVERSE_HIGH_MULTIPLICATION_$it",
        DEFAULT_DURATION,
        listOf(ProblemDefinition.ReverseMultiplication(1, it, 6, 10)),
        MODERATE_TIERS,
        "Multiplikation mit $it (6-10, Umkehraufgaben)",
        ""
    )
}

val COMBINED_MULTIPLICATIONS_1 = ExerciseDefinition(
    "COMBINED_MULTIPLICATIONS_1",
    DEFAULT_DURATION,
    listOf(
        ProblemDefinition.Multiplication(1, 1, 1, 10),
        ProblemDefinition.Multiplication(1, 10, 1, 10)
    ),
    MODERATE_TIERS,
    "Multiplikation mit 1 und 10",
    ""
)

val COMBINED_MULTIPLICATIONS_2 = ExerciseDefinition(
    "COMBINED_MULTIPLICATIONS_2",
    DEFAULT_DURATION,
    listOf(
        ProblemDefinition.Multiplication(1, 2, 1, 10),
        ProblemDefinition.Multiplication(1, 5, 1, 10),
        ProblemDefinition.Multiplication(1, 9, 1, 10)
    ),
    HARD_TIERS,
    "Multiplikation mit 2, 5 und 9",
    ""
)

val COMBINED_MULTIPLICATIONS_3 = ExerciseDefinition(
    "COMBINED_MULTIPLICATIONS_3",
    DEFAULT_DURATION,
    listOf(
        ProblemDefinition.Multiplication(1, 3, 1, 10),
        ProblemDefinition.Multiplication(1, 4, 1, 10),
        ProblemDefinition.Multiplication(1, 8, 1, 10)
    ),
    HARD_TIERS,
    "Multiplikation mit 3, 4 und 8",
    ""
)

val COMBINED_MULTIPLICATIONS_4 = ExerciseDefinition(
    "COMBINED_MULTIPLICATIONS_4",
    DEFAULT_DURATION,
    listOf(
        ProblemDefinition.Multiplication(1, 6, 1, 10),
        ProblemDefinition.Multiplication(1, 7, 1, 10)
    ),
    HARD_TIERS,
    "Multiplikation mit 1 und 10",
    ""
)

val COMBINED_MULTIPLICATIONS_5 = ExerciseDefinition(
    "COMBINED_MULTIPLICATIONS_5",
    DEFAULT_DURATION,
    listOf(
        ProblemDefinition.Multiplication(1, 1, 1, 10),
        ProblemDefinition.Multiplication(1, 2, 1, 10),
        ProblemDefinition.Multiplication(1, 3, 1, 10),
        ProblemDefinition.Multiplication(1, 4, 1, 10),
        ProblemDefinition.Multiplication(1, 5, 1, 10),
        ProblemDefinition.Multiplication(1, 6, 1, 10),
        ProblemDefinition.Multiplication(1, 7, 1, 10),
        ProblemDefinition.Multiplication(1, 8, 1, 10),
        ProblemDefinition.Multiplication(1, 9, 1, 10),
        ProblemDefinition.Multiplication(1, 10, 1, 10)
    ),
    HARD_TIERS,
    "Kleines Einmaleins",
    ""
)

val ALL_LOCAL_EXERCISES = listOf(
    ADD_5,
    ADD_10,
    ADD_20,
    ADD_100,
    ADD_5_10,
    REVERSE_ADD_5,
    REVERSE_ADD_10,
    REVERSE_ADD_20,
    REVERSE_ADD_100,
    COMBINED_ADD_10,
    COMBINED_ADD_20,
    COMBINED_ADD_100,

    SUB_5,
    SUB_5_10,
    SUB_10,
    SUB_20,
    SUB_100,
    REVERSE_SUB_5,
    REVERSE_SUB_10,
    REVERSE_SUB_20,
    REVERSE_SUB_100,
    COMBINED_SUB_10,
    COMBINED_SUB_20,
    COMBINED_SUB_100,

    *MULTIPLICATIONS_LOW.toTypedArray(),
    *MULTIPLICATIONS_HIGH.toTypedArray(),
    *MULTIPLICATIONS.toTypedArray(),
    *REVERSE_MULTIPLICATIONS_LOW.toTypedArray(),
    *REVERSE_MULTIPLICATIONS_HIGH.toTypedArray(),
    *REVERSE_MULTIPLICATIONS.toTypedArray(),

    COMBINED_MULTIPLICATIONS_1,
    COMBINED_MULTIPLICATIONS_2,
    COMBINED_MULTIPLICATIONS_3,
    COMBINED_MULTIPLICATIONS_4,
    COMBINED_MULTIPLICATIONS_5
)

// ==============================================================================
// LESSONS
// ==============================================================================

// ------------------------------------------------------------------------------
// Grade 1
// ------------------------------------------------------------------------------

val ADDITION_1 = LessonDefinition(
    "ADDITION_1",
    "Addition 1",
    "",
    listOf(ADD_5, ADD_5_10)
)

// ------------------------------------------------------------------------------
// Grade 2
// ------------------------------------------------------------------------------

val ADDITION_2 = LessonDefinition(
    "ADDITION_2",
    "Addition 2",
    "",
    listOf(ADD_10, REVERSE_ADD_10, COMBINED_ADD_10)
)

val SUBTRACTION_1 = LessonDefinition(
    "SUBTRACTION_1",
    "Subtraktion 1",
    "",
    listOf(SUB_5, SUB_5_10)
)

// ------------------------------------------------------------------------------
// Grade 3
// ------------------------------------------------------------------------------

val ADDITION_3 = LessonDefinition(
    "ADDITION_3",
    "Addition 3",
    "",
    listOf(ADD_20, REVERSE_ADD_20, COMBINED_ADD_20)
)

val SUBTRACTION_2 = LessonDefinition(
    "SUBTRACTION_2",
    "Subtraktion 2",
    "",
    listOf(SUB_10, REVERSE_SUB_10, COMBINED_SUB_10)
)

// ------------------------------------------------------------------------------
// Grade 4
// ------------------------------------------------------------------------------

val ADDITION_4 = LessonDefinition(
    "ADDITION_4",
    "Addition 4",
    "",
    listOf(ADD_100, REVERSE_ADD_100)
)

val SUBTRACTION_3 = LessonDefinition(
    "SUBTRACTION_3",
    "Subtraktion 3",
    "",
    listOf(SUB_20, REVERSE_SUB_20, COMBINED_SUB_20)
)

val MULTIPLICATION_1 = LessonDefinition(
    "MULTIPLICATION_1",
    "Multiplikation 1",
    "",
    listOf(
        MULTIPLICATIONS_LOW[0], MULTIPLICATIONS_HIGH[0], MULTIPLICATIONS[0],
        MULTIPLICATIONS_LOW[9], MULTIPLICATIONS_HIGH[9], MULTIPLICATIONS[9]
    )
)

// ------------------------------------------------------------------------------
// Grade 5
// ------------------------------------------------------------------------------

val ADDITION_5 = LessonDefinition(
    "ADDITION_5",
    "Addition 5",
    "",
    listOf(COMBINED_ADD_100)
)

val SUBTRACTION_4 = LessonDefinition(
    "SUBTRACTION_4",
    "Subtraktion 4",
    "",
    listOf(SUB_100, REVERSE_SUB_100)
)

val MULTIPLICATION_2 = LessonDefinition(
    "MULTIPLICATION_2",
    "Multiplikation 2",
    "",
    listOf(
        COMBINED_MULTIPLICATIONS_1,
        MULTIPLICATIONS_LOW[4], MULTIPLICATIONS_HIGH[4], MULTIPLICATIONS[4],
        MULTIPLICATIONS_LOW[1], MULTIPLICATIONS_HIGH[1], MULTIPLICATIONS[1],
        MULTIPLICATIONS_LOW[8], MULTIPLICATIONS_HIGH[8], MULTIPLICATIONS[8],
        REVERSE_MULTIPLICATIONS_LOW[0], REVERSE_MULTIPLICATIONS_HIGH[0], REVERSE_MULTIPLICATIONS[0],
        REVERSE_MULTIPLICATIONS_LOW[9], REVERSE_MULTIPLICATIONS_HIGH[9], REVERSE_MULTIPLICATIONS[9]
    )
)

// ------------------------------------------------------------------------------
// Grade 6
// ------------------------------------------------------------------------------

val SUBTRACTION_5 = LessonDefinition(
    "SUBTRACTION_5",
    "Subtraktion 5",
    "",
    listOf(COMBINED_SUB_100)
)

val MULTIPLICATION_3 = LessonDefinition(
    "MULTIPLICATION_3",
    "Multiplikation 3",
    "",
    listOf(
        COMBINED_MULTIPLICATIONS_2,
        MULTIPLICATIONS_LOW[2], MULTIPLICATIONS_HIGH[2], MULTIPLICATIONS[2],
        MULTIPLICATIONS_LOW[3], MULTIPLICATIONS_HIGH[3], MULTIPLICATIONS[3],
        MULTIPLICATIONS_LOW[7], MULTIPLICATIONS_HIGH[7], MULTIPLICATIONS[7],
        REVERSE_MULTIPLICATIONS_LOW[4], REVERSE_MULTIPLICATIONS_HIGH[4], REVERSE_MULTIPLICATIONS[4],
        REVERSE_MULTIPLICATIONS_LOW[1], REVERSE_MULTIPLICATIONS_HIGH[1], REVERSE_MULTIPLICATIONS[1],
        REVERSE_MULTIPLICATIONS_LOW[8], REVERSE_MULTIPLICATIONS_HIGH[8], REVERSE_MULTIPLICATIONS[8]
    )
)

// ------------------------------------------------------------------------------
// Grade 7
// ------------------------------------------------------------------------------

val MULTIPLICATION_4 = LessonDefinition(
    "MULTIPLICATION_4",
    "Multiplikation 4",
    "",
    listOf(
        COMBINED_MULTIPLICATIONS_3,
        MULTIPLICATIONS_LOW[5], MULTIPLICATIONS_HIGH[5], MULTIPLICATIONS[5],
        MULTIPLICATIONS_LOW[6], MULTIPLICATIONS_HIGH[6], MULTIPLICATIONS[6],
        REVERSE_MULTIPLICATIONS_LOW[2], REVERSE_MULTIPLICATIONS_HIGH[2], REVERSE_MULTIPLICATIONS[2],
        REVERSE_MULTIPLICATIONS_LOW[3], REVERSE_MULTIPLICATIONS_HIGH[3], REVERSE_MULTIPLICATIONS[3],
        REVERSE_MULTIPLICATIONS_LOW[7], REVERSE_MULTIPLICATIONS_HIGH[7], REVERSE_MULTIPLICATIONS[7]
    )
)

// ------------------------------------------------------------------------------
// Grade 8
// ------------------------------------------------------------------------------

val MULTIPLICATION_5 = LessonDefinition(
    "MULTIPLICATION_5",
    "Multiplikation 5",
    "",
    listOf(
        COMBINED_MULTIPLICATIONS_4,
        REVERSE_MULTIPLICATIONS_LOW[5], REVERSE_MULTIPLICATIONS_HIGH[5], REVERSE_MULTIPLICATIONS[5],
        REVERSE_MULTIPLICATIONS_LOW[6], REVERSE_MULTIPLICATIONS_HIGH[6], REVERSE_MULTIPLICATIONS[6]
    )
)

// ------------------------------------------------------------------------------
// Grade 9
// ------------------------------------------------------------------------------

val MULTIPLICATION_6 = LessonDefinition(
    "MULTIPLICATION_6",
    "Multiplikation 6",
    "",
    listOf(COMBINED_MULTIPLICATIONS_5)
)

val ALL_LOCAL_LESSONS = listOf(
    ADDITION_1, ADDITION_2, ADDITION_3, ADDITION_4, ADDITION_5,
    SUBTRACTION_1, SUBTRACTION_2, SUBTRACTION_3, SUBTRACTION_4, SUBTRACTION_5,
    MULTIPLICATION_1, MULTIPLICATION_2, MULTIPLICATION_3, MULTIPLICATION_4, MULTIPLICATION_5, MULTIPLICATION_6
)

val ALL_LOCAL_GRADES = listOf(
    GradeDefinition(0, "ADDITION_1"),
    GradeDefinition(1, "ADDITION_2", "SUBTRACTION_1"),
    GradeDefinition(2, "ADDITION_3", "SUBTRACTION_2"),
    GradeDefinition(3, "ADDITION_4", "SUBTRACTION_3", "MULTIPLICATION_1"),
    GradeDefinition(4, "ADDITION_5", "SUBTRACTION_4", "MULTIPLICATION_2"),
    GradeDefinition(5, null, "SUBTRACTION_5", "MULTIPLICATION_3"),
    GradeDefinition(6, multiplyLessonId = "MULTIPLICATION_4"),
    GradeDefinition(7, multiplyLessonId = "MULTIPLICATION_5"),
    GradeDefinition(8, multiplyLessonId = "MULTIPLICATION_6")
)
