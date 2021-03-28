package de.hkokocin.exercise.grade.ui

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.textview.MaterialTextView
import de.hkokocin.android.BaseActivity
import de.hkokocin.exercise.R
import de.hkokocin.redukt.BaseView
import de.hkokocin.toolkit.exhaustive
import de.hkokocin.toolkit.views.MarginItemDecoration
import de.hkokocin.uikit.setToolbar
import de.hkokocin.widgetadapter.WidgetAdapter
import kotlin.math.max

class GradeView(
    override val viewModel: GradeViewModel,
    private val activity: BaseActivity,
    private val adapter: WidgetAdapter,
    private val provideExerciseWidget: () -> ExerciseListItemWidget
) : BaseView() {

    //// VIEWS
    private val toolbar: MaterialToolbar by viewId(R.id.toolbar)
    private val tvLevel: MaterialTextView by viewId(R.id.tv_level)
    private val tvStarsCollected: MaterialTextView by viewId(R.id.tv_stars_collected)
    private val tvStarsRemaining: MaterialTextView by viewId(R.id.tv_stars_left)
    private val tvStarsToNextLevel: MaterialTextView by viewId(R.id.tv_stars_to_next_level)
    private val rvExercises: RecyclerView by viewId(R.id.rv_exercises)

    //// RESOURCES
    private val labelStarsCollected: String by resourceId(R.string.grade_stars_collected)
    private val labelStarsRemaining: String by resourceId(R.string.grade_stars_remaining)
    private val labelStarsToNextLevel: String by resourceId(R.string.grade_stars_to_next_level)
    private val margin by dimensionPixelSize(R.dimen.space_tiny)

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate(lifecycleOwner: LifecycleOwner) {
        bindViews()
        bindViewModel(lifecycleOwner.lifecycle)
    }

    private fun bindViews() {
        activity.setToolbar(toolbar)

        adapter.addWidget { provideExerciseWidget() }

        rvExercises.adapter = adapter
        rvExercises.layoutManager = LinearLayoutManager(rvExercises.context)
        rvExercises.addItemDecoration(MarginItemDecoration(margin))
    }

    private fun bindViewModel(lifecycle: Lifecycle) = viewModel.observe(lifecycle) {
        when (it) {
            is GradeViewState.Data -> updateData(it)
            is GradeViewState.Command -> it.command(activity)
        }.exhaustive
    }

    private fun updateData(data: GradeViewState.Data) {
        adapter.setItems(data.exercises)

        val indexOfFirstLockedExercise = data.exercises.indexOfFirst { !it.unlocked }
        rvExercises.scrollToPosition(max(indexOfFirstLockedExercise - 2, 0))
        rvExercises.scrollBy(0, -margin)

        val grade = data.grade
        tvLevel.text = grade.level.toString()
        tvStarsCollected.text = labelStarsCollected.format(grade.starsCollected)
        tvStarsRemaining.text = labelStarsRemaining.format(grade.starsRemaining)
        tvStarsToNextLevel.text = labelStarsToNextLevel.format(grade.starsToNextLevel, grade.nextLevel)
    }
}
