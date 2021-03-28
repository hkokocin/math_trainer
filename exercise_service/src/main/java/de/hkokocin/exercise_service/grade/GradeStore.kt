package de.hkokocin.exercise_service.grade

class GradeStore() {

    private val grades by lazy { ALL_LOCAL_GRADES }

    fun getGrade(arithmetic: Arithmetic): GradeDefinition? = grades.firstOrNull { it.type == arithmetic }
}
