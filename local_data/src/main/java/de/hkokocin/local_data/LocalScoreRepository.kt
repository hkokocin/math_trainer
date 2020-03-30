package de.hkokocin.local_data

import android.content.SharedPreferences
import androidx.core.content.edit

private const val SCORE_PREFIX = "SCORE_"

class LocalScoreRepository(
    private val sharedPreferences: SharedPreferences
) {
    fun getHighscore(exerciseDefinitionId: String) = sharedPreferences.getInt(SCORE_PREFIX + exerciseDefinitionId, 0)

    fun updateHighscore(exerciseDefinitionId: String, score: Int) = sharedPreferences.edit {
        if (getHighscore(exerciseDefinitionId) < score)
            putInt(SCORE_PREFIX + exerciseDefinitionId, score)
    }
}
