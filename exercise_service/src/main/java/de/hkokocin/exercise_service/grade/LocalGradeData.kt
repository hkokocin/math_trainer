package de.hkokocin.exercise_service.grade

import de.hkokocin.exercise_service.*


// ==============================================================================
// GRADES
// ==============================================================================

val ADDITION_GRADE = GradeDefinition(
    Arithmetic.ADDITION,
    listOf(
        ADD_5,
        ADD_5_10,
        ADD_10,
        REVERSE_ADD_10,
        COMBINED_ADD_10,
        ADD_20,
        REVERSE_ADD_20,
        COMBINED_ADD_20,
        ADD_100,
        REVERSE_ADD_100,
        COMBINED_ADD_100
    )
)

val SUBTRACTION_GRADE = GradeDefinition(
    Arithmetic.SUBTRACTION,
    listOf(
        SUB_5,
        SUB_5_10,
        SUB_10,
        REVERSE_SUB_10,
        COMBINED_SUB_10,
        SUB_20,
        REVERSE_SUB_20,
        COMBINED_SUB_20,
        SUB_100,
        REVERSE_SUB_100,
        COMBINED_SUB_100
    )
)

val MULTIPLICATION_GRADE = GradeDefinition(
    Arithmetic.MULTIPLICATION,
    listOf(
        MULTIPLICATIONS_LOW[0], MULTIPLICATIONS_HIGH[0], MULTIPLICATIONS[0],
        MULTIPLICATIONS_LOW[9], MULTIPLICATIONS_HIGH[9], MULTIPLICATIONS[9],
        COMBINED_MULTIPLICATIONS_1,
        MULTIPLICATIONS_LOW[4], MULTIPLICATIONS_HIGH[4], MULTIPLICATIONS[4],
        MULTIPLICATIONS_LOW[1], MULTIPLICATIONS_HIGH[1], MULTIPLICATIONS[1],
        MULTIPLICATIONS_LOW[8], MULTIPLICATIONS_HIGH[8], MULTIPLICATIONS[8],
        REVERSE_MULTIPLICATIONS_LOW[0], REVERSE_MULTIPLICATIONS_HIGH[0], REVERSE_MULTIPLICATIONS[0],
        REVERSE_MULTIPLICATIONS_LOW[9], REVERSE_MULTIPLICATIONS_HIGH[9], REVERSE_MULTIPLICATIONS[9],
        COMBINED_MULTIPLICATIONS_2,
        MULTIPLICATIONS_LOW[2], MULTIPLICATIONS_HIGH[2], MULTIPLICATIONS[2],
        MULTIPLICATIONS_LOW[3], MULTIPLICATIONS_HIGH[3], MULTIPLICATIONS[3],
        MULTIPLICATIONS_LOW[7], MULTIPLICATIONS_HIGH[7], MULTIPLICATIONS[7],
        REVERSE_MULTIPLICATIONS_LOW[4], REVERSE_MULTIPLICATIONS_HIGH[4], REVERSE_MULTIPLICATIONS[4],
        REVERSE_MULTIPLICATIONS_LOW[1], REVERSE_MULTIPLICATIONS_HIGH[1], REVERSE_MULTIPLICATIONS[1],
        REVERSE_MULTIPLICATIONS_LOW[8], REVERSE_MULTIPLICATIONS_HIGH[8], REVERSE_MULTIPLICATIONS[8],
        COMBINED_MULTIPLICATIONS_3,
        MULTIPLICATIONS_LOW[5], MULTIPLICATIONS_HIGH[5], MULTIPLICATIONS[5],
        MULTIPLICATIONS_LOW[6], MULTIPLICATIONS_HIGH[6], MULTIPLICATIONS[6],
        REVERSE_MULTIPLICATIONS_LOW[2], REVERSE_MULTIPLICATIONS_HIGH[2], REVERSE_MULTIPLICATIONS[2],
        REVERSE_MULTIPLICATIONS_LOW[3], REVERSE_MULTIPLICATIONS_HIGH[3], REVERSE_MULTIPLICATIONS[3],
        REVERSE_MULTIPLICATIONS_LOW[7], REVERSE_MULTIPLICATIONS_HIGH[7], REVERSE_MULTIPLICATIONS[7],
        COMBINED_MULTIPLICATIONS_4,
        REVERSE_MULTIPLICATIONS_LOW[5], REVERSE_MULTIPLICATIONS_HIGH[5], REVERSE_MULTIPLICATIONS[5],
        REVERSE_MULTIPLICATIONS_LOW[6], REVERSE_MULTIPLICATIONS_HIGH[6], REVERSE_MULTIPLICATIONS[6],
        COMBINED_MULTIPLICATIONS_5
    )
)

val DIVISION_GRADE = GradeDefinition(
    Arithmetic.DIVISION,
    listOf()
)

val ALL_LOCAL_GRADES = listOf(
    ADDITION_GRADE,
    SUBTRACTION_GRADE,
    MULTIPLICATION_GRADE,
    DIVISION_GRADE
)