package de.hkokocin.exercise_service

//private val EASY_TIERS = listOf(8, 16, 22)
//private val MODERATE_TIERS = listOf(7, 14, 18)
//private val HARD_TIERS = listOf(6, 10, 14)
//private val X_HARD_TIERS = listOf(5, 9, 12)

private val EASY_TIERS = listOf(5, 10, 15)
private val MODERATE_TIERS = listOf(4, 8, 12)
private val HARD_TIERS = listOf(3, 6, 10)
private val X_HARD_TIERS = listOf(3, 5, 8)

private const val DEFAULT_DURATION = 60

// ==============================================================================
// EXERCISES
// ==============================================================================

// ------------------------------------------------------------------------------
// ADDITION
// ------------------------------------------------------------------------------

val ADD_5 = ExerciseDefinition(
    "ADD_5",
    DEFAULT_DURATION,
    listOf(ProblemDefinition.Numeric.Addition(1, 0, 5)),
    EASY_TIERS,
    "Addition bis 5",
    ""
)

val REVERSE_ADD_5 = ExerciseDefinition(
    "REVERSE_ADD_5",
    DEFAULT_DURATION,
    listOf(ProblemDefinition.Numeric.ReverseAddition(1, 0, 5)),
    MODERATE_TIERS,
    "Addition bis 5 (Umkehraufgaben)",
    ""
)

val ADD_5_10 = ExerciseDefinition(
    "ADD_5_10",
    DEFAULT_DURATION,
    listOf(ProblemDefinition.Numeric.Addition(1, 6, 10)),
    EASY_TIERS,
    "Addition von 5 bis 10",
    ""
)

val ADD_10 = ExerciseDefinition(
    "ADD_10",
    DEFAULT_DURATION,
    listOf(ProblemDefinition.Numeric.Addition(1, 0, 10)),
    EASY_TIERS,
    "Addition bis 10",
    ""
)

val REVERSE_ADD_10 = ExerciseDefinition(
    "REVERSE_ADD_10",
    DEFAULT_DURATION,
    listOf(ProblemDefinition.Numeric.ReverseAddition(1, 0, 10)),
    MODERATE_TIERS,
    "Addition bis 10 (Umkehraufgaben)",
    ""
)

val COMBINED_ADD_10 = ExerciseDefinition(
    "COMBINED_ADD_10",
    DEFAULT_DURATION,
    listOf(
        ProblemDefinition.Numeric.Addition(1, 0, 10),
        ProblemDefinition.Numeric.ReverseAddition(1, 0, 10)
    ),
    MODERATE_TIERS,
    "Addition bis 10 (gemischt)",
    ""
)

val ADD_20 = ExerciseDefinition(
    "ADD_20",
    DEFAULT_DURATION,
    listOf(ProblemDefinition.Numeric.Addition(1, 11, 20)),
    EASY_TIERS,
    "Addition bis 20",
    ""
)

val REVERSE_ADD_20 = ExerciseDefinition(
    "REVERSE_ADD_20",
    DEFAULT_DURATION,
    listOf(ProblemDefinition.Numeric.ReverseAddition(1, 11, 20)),
    MODERATE_TIERS,
    "Addition bis 20 (Umkehraufgaben)",
    ""
)

val COMBINED_ADD_20 = ExerciseDefinition(
    "COMBINED_ADD_20",
    DEFAULT_DURATION,
    listOf(
        ProblemDefinition.Numeric.Addition(1, 11, 20),
        ProblemDefinition.Numeric.ReverseAddition(1, 11, 20)
    ),
    MODERATE_TIERS,
    "Addition bis 20 (gemischt)",
    ""
)

val ADD_100 = ExerciseDefinition(
    "ADD_100",
    DEFAULT_DURATION,
    listOf(ProblemDefinition.Numeric.Addition(1, 21, 100)),
    HARD_TIERS,
    "Addition bis 100",
    ""
)

val REVERSE_ADD_100 = ExerciseDefinition(
    "REVERSE_ADD_100",
    DEFAULT_DURATION,
    listOf(ProblemDefinition.Numeric.ReverseAddition(1, 21, 100)),
    X_HARD_TIERS,
    "Addition bis 100 (Umkehraufgaben)",
    ""
)

val COMBINED_ADD_100 = ExerciseDefinition(
    "COMBINED_ADD_100",
    DEFAULT_DURATION,
    listOf(
        ProblemDefinition.Numeric.Addition(1, 0, 100),
        ProblemDefinition.Numeric.ReverseAddition(1, 0, 100)
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
    listOf(ProblemDefinition.Numeric.Subtraction(1, 0, 5)),
    EASY_TIERS,
    "Subtraktion bis 5",
    ""
)

val SUB_5_10 = ExerciseDefinition(
    "SUB_5",
    DEFAULT_DURATION,
    listOf(ProblemDefinition.Numeric.Subtraction(1, 6, 10)),
    EASY_TIERS,
    "Subtraktion 5 - 10",
    ""
)

val REVERSE_SUB_5 = ExerciseDefinition(
    "REVERSE_SUB_5",
    DEFAULT_DURATION,
    listOf(ProblemDefinition.Numeric.ReverseSubtraction(1, 0, 5)),
    EASY_TIERS,
    "Subtraktion bis 5 (Umkehraufgaben)",
    ""
)

val SUB_10 = ExerciseDefinition(
    "SUB_10",
    DEFAULT_DURATION,
    listOf(ProblemDefinition.Numeric.Subtraction(1, 0, 10)),
    EASY_TIERS,
    "Subtraktion bis 10",
    ""
)

val REVERSE_SUB_10 = ExerciseDefinition(
    "REVERSE_SUB_10",
    DEFAULT_DURATION,
    listOf(ProblemDefinition.Numeric.ReverseSubtraction(1, 0, 10)),
    MODERATE_TIERS,
    "Subtraktion bis 10 (Umkehraufgaben)",
    ""
)

val COMBINED_SUB_10 = ExerciseDefinition(
    "COMBINED_SUB_10",
    DEFAULT_DURATION,
    listOf(
        ProblemDefinition.Numeric.Subtraction(1, 0, 10),
        ProblemDefinition.Numeric.ReverseSubtraction(1, 0, 10)
    ),
    MODERATE_TIERS,
    "Subtraktion bis 10 (Umkehraufgaben)",
    ""
)

val SUB_20 = ExerciseDefinition(
    "SUB_20",
    DEFAULT_DURATION,
    listOf(ProblemDefinition.Numeric.Subtraction(1, 0, 20)),
    EASY_TIERS,
    "Subtraktion bis 20",
    ""
)

val REVERSE_SUB_20 = ExerciseDefinition(
    "REVERSE_SUB_20",
    DEFAULT_DURATION,
    listOf(ProblemDefinition.Numeric.ReverseSubtraction(1, 0, 20)),
    MODERATE_TIERS,
    "Subtraktion bis 20 (Umkehraufgaben)",
    ""
)

val COMBINED_SUB_20 = ExerciseDefinition(
    "COMBINED_SUB_20",
    DEFAULT_DURATION,
    listOf(
        ProblemDefinition.Numeric.Subtraction(1, 0, 20),
        ProblemDefinition.Numeric.ReverseSubtraction(1, 0, 20)
    ),
    MODERATE_TIERS,
    "Subtraktion bis 20 (gemischt)",
    ""
)

val SUB_100 = ExerciseDefinition(
    "SUB_100",
    DEFAULT_DURATION,
    listOf(ProblemDefinition.Numeric.Subtraction(1, 0, 100)),
    HARD_TIERS,
    "Subtraktion bis 100",
    ""
)

val REVERSE_SUB_100 = ExerciseDefinition(
    "REVERSE_SUB_100",
    DEFAULT_DURATION,
    listOf(ProblemDefinition.Numeric.ReverseSubtraction(1, 0, 100)),
    X_HARD_TIERS,
    "Subtraktion bis 100 (Umkehraufgaben)",
    ""
)

val COMBINED_SUB_100 = ExerciseDefinition(
    "COMBINED_SUB_100",
    DEFAULT_DURATION,
    listOf(
        ProblemDefinition.Numeric.Subtraction(1, 0, 100),
        ProblemDefinition.Numeric.ReverseSubtraction(1, 0, 100)
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
        listOf(ProblemDefinition.Numeric.Multiplication(1, it, 1, 10)),
        MODERATE_TIERS,
        "Multiplikation mit $it",
        ""
    )
}

val MULTIPLICATIONS_LOW = (1..10).map {
    ExerciseDefinition(
        "MULTIPLICATION_LOW_$it",
        DEFAULT_DURATION,
        listOf(ProblemDefinition.Numeric.Multiplication(1, it, 1, 5)),
        MODERATE_TIERS,
        "Multiplikation mit $it (1-5)",
        ""
    )
}

val MULTIPLICATIONS_HIGH = (1..10).map {
    ExerciseDefinition(
        "MULTIPLICATION_HIGH_$it",
        DEFAULT_DURATION,
        listOf(ProblemDefinition.Numeric.Multiplication(1, it, 6, 10)),
        MODERATE_TIERS,
        "Multiplikation mit $it (6-10)",
        ""
    )
}

val REVERSE_MULTIPLICATIONS = (1..10).map {
    ExerciseDefinition(
        "REVERSE_MULTIPLICATION_$it",
        DEFAULT_DURATION,
        listOf(ProblemDefinition.Numeric.ReverseMultiplication(1, it, 1, 10)),
        HARD_TIERS,
        "Multiplikation mit $it (Umkehraufgaben)",
        ""
    )
}

val REVERSE_MULTIPLICATIONS_LOW = (1..10).map {
    ExerciseDefinition(
        "REVERSE_LOW_MULTIPLICATION_$it",
        DEFAULT_DURATION,
        listOf(ProblemDefinition.Numeric.ReverseMultiplication(1, it, 1, 5)),
        MODERATE_TIERS,
        "Multiplikation mit $it (1-5, Umkehraufgaben)",
        ""
    )
}

val REVERSE_MULTIPLICATIONS_HIGH = (1..10).map {
    ExerciseDefinition(
        "REVERSE_HIGH_MULTIPLICATION_$it",
        DEFAULT_DURATION,
        listOf(ProblemDefinition.Numeric.ReverseMultiplication(1, it, 6, 10)),
        MODERATE_TIERS,
        "Multiplikation mit $it (6-10, Umkehraufgaben)",
        ""
    )
}

val COMBINED_MULTIPLICATIONS_1 = ExerciseDefinition(
    "COMBINED_MULTIPLICATIONS_1",
    DEFAULT_DURATION,
    listOf(
        ProblemDefinition.Numeric.Multiplication(1, 1, 1, 10),
        ProblemDefinition.Numeric.Multiplication(1, 10, 1, 10)
    ),
    MODERATE_TIERS,
    "Multiplikation mit 1 und 10",
    ""
)

val COMBINED_MULTIPLICATIONS_2 = ExerciseDefinition(
    "COMBINED_MULTIPLICATIONS_2",
    DEFAULT_DURATION,
    listOf(
        ProblemDefinition.Numeric.Multiplication(1, 2, 1, 10),
        ProblemDefinition.Numeric.Multiplication(1, 5, 1, 10),
        ProblemDefinition.Numeric.Multiplication(1, 9, 1, 10)
    ),
    HARD_TIERS,
    "Multiplikation mit 2, 5 und 9",
    ""
)

val COMBINED_MULTIPLICATIONS_3 = ExerciseDefinition(
    "COMBINED_MULTIPLICATIONS_3",
    DEFAULT_DURATION,
    listOf(
        ProblemDefinition.Numeric.Multiplication(1, 3, 1, 10),
        ProblemDefinition.Numeric.Multiplication(1, 4, 1, 10),
        ProblemDefinition.Numeric.Multiplication(1, 8, 1, 10)
    ),
    HARD_TIERS,
    "Multiplikation mit 3, 4 und 8",
    ""
)

val COMBINED_MULTIPLICATIONS_4 = ExerciseDefinition(
    "COMBINED_MULTIPLICATIONS_4",
    DEFAULT_DURATION,
    listOf(
        ProblemDefinition.Numeric.Multiplication(1, 6, 1, 10),
        ProblemDefinition.Numeric.Multiplication(1, 7, 1, 10)
    ),
    HARD_TIERS,
    "Multiplikation mit 1 und 10",
    ""
)

val COMBINED_MULTIPLICATIONS_5 = ExerciseDefinition(
    "COMBINED_MULTIPLICATIONS_5",
    DEFAULT_DURATION,
    listOf(
        ProblemDefinition.Numeric.Multiplication(1, 1, 1, 10),
        ProblemDefinition.Numeric.Multiplication(1, 2, 1, 10),
        ProblemDefinition.Numeric.Multiplication(1, 3, 1, 10),
        ProblemDefinition.Numeric.Multiplication(1, 4, 1, 10),
        ProblemDefinition.Numeric.Multiplication(1, 5, 1, 10),
        ProblemDefinition.Numeric.Multiplication(1, 6, 1, 10),
        ProblemDefinition.Numeric.Multiplication(1, 7, 1, 10),
        ProblemDefinition.Numeric.Multiplication(1, 8, 1, 10),
        ProblemDefinition.Numeric.Multiplication(1, 9, 1, 10),
        ProblemDefinition.Numeric.Multiplication(1, 10, 1, 10)
    ),
    HARD_TIERS,
    "Kleines Einmaleins",
    ""
)

// ==============================================================================
// Division
// ==============================================================================


val DIVISIONS = (1..10).map {
    ExerciseDefinition(
        "DIVISION_$it",
        DEFAULT_DURATION,
        listOf(ProblemDefinition.Numeric.Division(1, it, 1, 10)),
        MODERATE_TIERS,
        "Division mit $it",
        ""
    )
}

val DIVISIONS_LOW = (1..10).map {
    ExerciseDefinition(
        "DIVISION_LOW_$it",
        DEFAULT_DURATION,
        listOf(ProblemDefinition.Numeric.Division(1, it, 1, 5)),
        MODERATE_TIERS,
        "Division mit $it (1-5)",
        ""
    )
}

val DIVISIONS_HIGH = (1..10).map {
    ExerciseDefinition(
        "DIVISION_HIGH_$it",
        DEFAULT_DURATION,
        listOf(ProblemDefinition.Numeric.Division(1, it, 6, 10)),
        MODERATE_TIERS,
        "Division mit $it (6-10)",
        ""
    )
}

//val REVERSE_DIVISIONS = (1..10).map {
//    ExerciseDefinition(
//        "REVERSE_DIVISION_$it",
//        DEFAULT_DURATION,
//        listOf(ProblemDefinition.Numeric.ReverseDivision(1, it, 1, 10)),
//        HARD_TIERS,
//        "Division mit $it (Umkehraufgaben)",
//        ""
//    )
//}
//
//val REVERSE_DIVISIONS_LOW = (1..10).map {
//    ExerciseDefinition(
//        "REVERSE_LOW_DIVISION_$it",
//        DEFAULT_DURATION,
//        listOf(ProblemDefinition.Numeric.ReverseDivision(1, it, 1, 5)),
//        MODERATE_TIERS,
//        "Division mit $it (1-5, Umkehraufgaben)",
//        ""
//    )
//}
//
//val REVERSE_DIVISIONS_HIGH = (1..10).map {
//    ExerciseDefinition(
//        "REVERSE_HIGH_DIVISION_$it",
//        DEFAULT_DURATION,
//        listOf(ProblemDefinition.Numeric.ReverseDivision(1, it, 6, 10)),
//        MODERATE_TIERS,
//        "Division mit $it (6-10, Umkehraufgaben)",
//        ""
//    )
//}


// ==============================================================================
// Collections
// ==============================================================================


val ALL_LOCAL_EXERCISES = listOf<ExerciseDefinition>(
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
