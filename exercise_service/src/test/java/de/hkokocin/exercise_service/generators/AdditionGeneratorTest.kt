package de.hkokocin.exercise_service.generators

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.given
import com.nhaarman.mockitokotlin2.mock
import de.hkokocin.exercise_service.ProblemDefinition
import de.hkokocin.testkit.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.random.Random

class AdditionGeneratorTest {

    val optionsGenerator: OptionsGenerator = mock()
    val random: Random = mock()

    val classToTest = AdditionGenerator(optionsGenerator, random)

    val problemDefinition = ProblemDefinition.Addition(1, 10)

    @BeforeEach
    fun beforeEachTest() {
        given(optionsGenerator.generateOptions(any(), any())).willReturn(emptyList())
    }

    @Nested
    inner class `when randomizing a new problem`{

        @BeforeEach
        fun beforeEachTest() {
            given(random.nextInt(2, 11)).willReturn(8)
            given(random.nextInt(1, 8)).willReturn(5)
        }

        @Test
        fun `it generates a human readable problem declaration`() {
            val problem = classToTest.create(problemDefinition)

            assertThat(problem.problem).isEqualTo("5 + 3")
        }

        @Test
        fun `it randomizes the solution`() {
            val problem = classToTest.create(problemDefinition)

            assertThat(problem.solution).isEqualTo(8)
        }
    }
}
