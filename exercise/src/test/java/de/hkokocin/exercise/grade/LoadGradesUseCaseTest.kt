package de.hkokocin.exercise.grade

import com.nhaarman.mockitokotlin2.given
import com.nhaarman.mockitokotlin2.mock
import de.hkokocin.exercise_service.*
import de.hkokocin.local_data.LocalScoreRepository
import de.hkokocin.testkit.assertThat
import de.hkokocin.testkit.blocking
import de.hkokocin.testkit.willDefer
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class LoadGradesUseCaseTest {

    val exercisesRepository: ExercisesRepository = mock()
    val localScoreRepository: LocalScoreRepository = mock()

    val classToTest = LoadGradesUseCase(exercisesRepository, localScoreRepository)


    val exercise1 = ExerciseDefinition(
        "exerciseId1", 60, listOf(ProblemDefinition.Addition(1, 5)), listOf(10, 20, 30), "Title 1", ""
    )

    val exercise2 = ExerciseDefinition(
        "exerciseId2", 90, listOf(ProblemDefinition.Addition(1, 10)), listOf(10, 20, 30), "Title 2", ""
    )

    val lesson1 = LessonDefinition("lessonId1", "lessonTitle1", "lessonDescription1", listOf(exercise1, exercise2))
    val lesson2 = LessonDefinition("lessonId2", "lessonTitle2", "lessonDescription2", listOf(exercise1))

    val gradeDefinitions = listOf(
        GradeDefinition(0, listOf("lessonId1", "lessonId2")),
        GradeDefinition(1, listOf("lessonId1"))
    )

    val emit: (GradeViewState) -> Unit = {}

    @BeforeEach
    fun beforeEachTest() = blocking {
        given(exercisesRepository.getGradeDefinitions()).willDefer(gradeDefinitions)
        given(exercisesRepository.getLesson("lessonId1")).willReturn(lesson1)
        given(exercisesRepository.getLesson("lessonId2")).willReturn(lesson2)

        given(localScoreRepository.getHighscore("exerciseId1")).willReturn(1)
        given(localScoreRepository.getHighscore("exerciseId2")).willReturn(2)
    }

    @Test
    fun `it can load all grades`() = blocking {
        val result = classToTest.adopt(emit)

        assertThat(result).hasSize(2)
    }

    @Test
    fun `it always sets the first grade to unlocked`() = blocking {
        val result = classToTest.adopt(emit)

        assertThat(result[0].unlocked).isFalse()

    }

    @Test
    fun `it sets a grade to locked if user archieved less then 66% stars in the previous grade`() = blocking {
        val result = classToTest.adopt(emit)

        assertThat(result[1].unlocked).isFalse()
    }

    @Test
    fun `it sets a grade to unlocked if user archieved more then 66% stars in the previous grade`() = blocking {
        given(localScoreRepository.getHighscore("exerciseId1")).willReturn(30)
        given(localScoreRepository.getHighscore("exerciseId2")).willReturn(30)

        val result = classToTest.adopt(emit)

        assertThat(result[1].unlocked).isTrue()
    }

    @Nested
    inner class `it creates a progress widget`{

        @BeforeEach
        fun beforeEachTest() {
            given(localScoreRepository.getHighscore("exerciseId1")).willReturn(10)
            given(localScoreRepository.getHighscore("exerciseId2")).willReturn(20)
        }


        @Test
        fun `as the first item in within a grade row`() = blocking {
            val result = classToTest.adopt(emit)

            assertThat(result[0].rowItems[0]).isInstanceOf(GradeProgressWidgetState::class.java)
        }

        @Test
        fun `with the correct number of total stars`() = blocking {
            val result = classToTest.adopt(emit)

            val progressItem = result[0].rowItems[0] as GradeProgressWidgetState
            assertThat(progressItem.totalStars).isEqualTo(9)
        }

        @Test
        fun `with the correct number of stars`() = blocking {
            val result = classToTest.adopt(emit)

            val progressItem = result[0].rowItems[0] as GradeProgressWidgetState
            assertThat(progressItem.progressStars).isEqualTo(4)
        }

        @Test
        fun `with locked state if user archieved less then 66% stars in the previous grade`() = blocking {
            val result = classToTest.adopt(emit)

            assertThat(result[1].unlocked).isFalse()
        }

        @Test
        fun `with unlocked state if user archieved more then 66% stars in the previous grade`() = blocking {
            given(localScoreRepository.getHighscore("exerciseId1")).willReturn(30)
            given(localScoreRepository.getHighscore("exerciseId2")).willReturn(30)

            val result = classToTest.adopt(emit)

            assertThat(result[1].unlocked).isTrue()
        }
    }
}
