package de.hkokocin.exercise.lesson

import android.os.Bundle
import de.hkokocin.android.BaseActivity
import de.hkokocin.exercise.R
import org.kodein.di.KodeinAware
import org.kodein.di.erased.instance

class LessonActivity: BaseActivity(), KodeinAware {

    object EXTRA {
        const val LESSON_ID = "EXTRA_LESSON_ID"
    }

    override val kodein by lazy { lessonScope(this) }

    private val exerciseView by instance<LessonView>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(exerciseView, R.layout.lesson_view)
    }
}
