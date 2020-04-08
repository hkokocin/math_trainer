package de.hkokocin.exercise.grade

import de.hkokocin.android.startActivity
import de.hkokocin.exercise.R
import de.hkokocin.exercise.lesson.LessonActivity
import de.hkokocin.exercise_service.*
import de.hkokocin.local_data.LocalScoreRepository

class LoadGradesUseCase(
    private val exercisesRepository: ExercisesRepository,
    private val scoreRepository: LocalScoreRepository
) {

    suspend fun adopt(emit: (GradeViewState) -> Unit): List<GradeViewPageState> {
        val gradeDefinitions = exercisesRepository.getGradeDefinitions().await()

        val lessonDefinitions = gradeDefinitions
            .flatMap { loadLessons(it) }
            .toMap()

        val starsByLessonId = lessonDefinitions.values.getStarsById()
        val starsByGrade = gradeDefinitions.map { it.lessonIds.mapNotNull { starsByLessonId[it] }.sum() }

        return gradeDefinitions.mapIndexed { index, grade ->
            val starsCollected = starsByGrade[index]
            val totalStars = grade.getTotalStars(lessonDefinitions)
            val starsToUnlockNextLevel = (totalStars * UNLOCK_GRADE_STAR_RATIO).toInt()

            GradeViewPageState(
                index = index,
                starsCollected = starsCollected,
                starsRemaining = totalStars - starsCollected,
                starsToNextLevel = totalStars - starsToUnlockNextLevel,
                addLesson = createLessonViewState(lessonDefinitions[grade.addLessonId], starsByLessonId, emit),
                subtractLesson = createLessonViewState(lessonDefinitions[grade.subtractLessonId], starsByLessonId, emit),
                multiplyLesson = createLessonViewState(lessonDefinitions[grade.multiplyLessonId], starsByLessonId, emit),
                divideLesson = createLessonViewState(lessonDefinitions[grade.divideLessonId], starsByLessonId, emit),
                unlocked = isGradeUnlocked(index, gradeDefinitions, starsByGrade, lessonDefinitions)
            )
        }
    }

    private fun isGradeUnlocked(
        index: Int,
        gradeDefinitions: List<GradeDefinition>,
        starsByGrade: List<Int>,
        lessonDefinitions: Map<String, LessonDefinition>
    ): Boolean {
        if(index == 0) return true

        val starsCollected = starsByGrade[index]
        val totalStars = gradeDefinitions[index - 1].getTotalStars(lessonDefinitions)
        val starsToUnlockNextLevel = (totalStars * UNLOCK_GRADE_STAR_RATIO).toInt()

        return starsCollected >= starsToUnlockNextLevel
    }

    private suspend fun loadLessons(grade: GradeDefinition) = listOfNotNull(
        grade.addLessonId,
        grade.subtractLessonId,
        grade.multiplyLessonId,
        grade.divideLessonId
    )
        .map { it to exercisesRepository.getLesson(it) }

    private fun GradeDefinition.getTotalStars(lessonDefinitions: Map<String, LessonDefinition>) = lessonIds
        .mapNotNull { lessonDefinitions[it] }
        .map { it.exercises.size * 3 }
        .sum()

    private val GradeDefinition.lessonIds
        get() = listOfNotNull(
            addLessonId,
            subtractLessonId,
            multiplyLessonId,
            divideLessonId
        )

    private fun Collection<LessonDefinition>.getStarsById() = map { lesson ->
        val stars = lesson.exercises.map {
            it.calculateStars(scoreRepository.getHighscore(it.id))
        }.sum()
        lesson.id to stars
    }.toMap()


    private suspend fun createLessonViewState(
        definition: LessonDefinition?,
        starsByLessonId: Map<String, Int>,
        emit: (GradeViewState) -> Unit
    ): LessonState? {
        definition ?: return null

        val stars = starsByLessonId[definition.id] ?: return null
        val totalStars = definition.exercises.size * MAX_STARS
        val onClick = onLessonSelected(definition, getTheme(definition.id), emit)
        return LessonState(definition.title, stars, totalStars, true, true, onClick)
    }

    private fun onLessonSelected(lesson: LessonDefinition, theme: Int, emit: (GradeViewState) -> Unit): () -> Unit = {
        val command = startActivity<LessonActivity> {
            putExtra(LessonActivity.EXTRA.LESSON_ID, lesson.id)
            putExtra(LessonActivity.EXTRA.THEME, theme)
        }
        emit(GradeViewState.Command(command))
    }


    private suspend fun getTheme(lessonId: String): Int {
        val grades = exercisesRepository.getGradeDefinitions().await()
        grades.forEach {
            if(it.addLessonId == lessonId) return R.style.AppTheme_Green
            if(it.subtractLessonId == lessonId) return R.style.AppTheme_Purple
            if(it.multiplyLessonId == lessonId) return R.style.AppTheme_Cyan
            if(it.divideLessonId == lessonId) return R.style.AppTheme_Orange
        }

        return R.style.AppTheme_Teal
    }
}
