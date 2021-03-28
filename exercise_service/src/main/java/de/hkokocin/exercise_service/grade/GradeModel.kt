package de.hkokocin.exercise_service.grade

import de.hkokocin.exercise_service.ExerciseDefinition

enum class Arithmetic{
    ADDITION,
    SUBTRACTION,
    MULTIPLICATION,
    DIVISION
}

data class GradeDefinition(
    val type: Arithmetic,
    val exercises: List<ExerciseDefinition>
)
