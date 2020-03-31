package de.hkokocin.exercise.exercise

import android.os.Bundle
import de.hkokocin.android.BaseActivity
import de.hkokocin.exercise.R
import org.kodein.di.KodeinAware
import org.kodein.di.erased.instance


class ExerciseActivity : BaseActivity(), KodeinAware {
    override val kodein by lazy { exerciseScope(this) }

    object EXTRA {
        const val EXERCISE_DEFINITION_ID = "EXERCISE_DEFINITION_ID"
    }

    private val exerciseView by instance<ExerciseView>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(exerciseView, R.layout.exercise_view)
    }
}
