package de.hkokocin.exercise_service

data class Problem(
    val problem: String,
    val solution: Int,
    val options: List<Int>,
    val score: Int
)
