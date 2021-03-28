package de.hkokocin.exercise.grade.domain

import de.hkokocin.testkit.assertThat
import org.junit.jupiter.api.Test
import kotlin.math.ceil

internal class LoadGradeUseCaseTest {

    @Test
    fun `can calculate level`() {
        val collectedStars = 20
        val maxStars = 100

        val level = (collectedStars.toFloat() * 10 / maxStars).toInt()

        assertThat(level).isEqualTo(3)
    }

    @Test
    fun `can calculate stars to next level`() {
        val nextLevel = 3
        val currentStars = 22
        val maxStars = 100

        val missingStars = ceil(nextLevel * maxStars / 10f).toInt() - currentStars

        assertThat(missingStars).isEqualTo(8)
    }

}
