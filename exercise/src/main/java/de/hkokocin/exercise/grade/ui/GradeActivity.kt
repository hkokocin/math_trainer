package de.hkokocin.exercise.grade.ui

import android.os.Bundle
import de.hkokocin.android.BaseActivity
import de.hkokocin.exercise.R
import de.hkokocin.exercise.grade.gradeScope
import org.kodein.di.KodeinAware
import org.kodein.di.erased.instance

class GradeActivity : BaseActivity(), KodeinAware {

    override val kodein by lazy { gradeScope(this) }

    private val view by instance<GradeView>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(view, R.layout.grade_view)
    }
}
