package de.hkokocin.exercise.grade

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.appbar.MaterialToolbar
import de.hkokocin.android.BaseActivity
import de.hkokocin.exercise.R
import de.hkokocin.exercise.grade.GradeViewState.Command
import de.hkokocin.exercise.grade.GradeViewState.UpdateGrades
import de.hkokocin.redukt.BaseView
import de.hkokocin.uikit.setToolbar
import de.hkokocin.widgetadapter.WidgetAdapter


class GradeView(
    private val viewModel: GradeViewModel,
    private val activity: BaseActivity,
    private val adapter: WidgetAdapter
) : BaseView() {

    private val toolbar: MaterialToolbar by viewId(R.id.toolbar)
    private val vpGrades: ViewPager2 by viewId(R.id.vp_grades)

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate(lifecycleOwner: LifecycleOwner) {
        bindViews()
        bindViewModel(lifecycleOwner.lifecycle)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() {
        viewModel.dispatch(ViewResumed)
    }

    private fun bindViews() {
        activity.setToolbar(toolbar)
        adapter.addWidget { GradeViewPageWidget() }
        vpGrades.adapter = adapter
    }

    private fun bindViewModel(lifecycle: Lifecycle) = viewModel.observe(lifecycle) {
        when (it) {
            is UpdateGrades -> adapter.setItems(it.grades)
            is Command -> it.command(activity)
        }
    }
}
