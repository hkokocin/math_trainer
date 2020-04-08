package de.hkokocin.exercise.lesson

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.MaterialToolbar
import de.hkokocin.android.BaseActivity
import de.hkokocin.exercise.R
import de.hkokocin.exercise.lesson.LessonViewState.*
import de.hkokocin.redukt.BaseView
import de.hkokocin.toolkit.android_extensions.extra
import de.hkokocin.toolkit.views.MarginItemDecoration
import de.hkokocin.uikit.setToolbar
import de.hkokocin.widgetadapter.WidgetAdapter

class LessonView(
    private val viewModel: LessonViewModel,
    private val adapter: WidgetAdapter,
    private val activity: BaseActivity
) : BaseView() {

    private val toolbar: MaterialToolbar by viewId(R.id.toolbar)
    private val rvExercises: RecyclerView by viewId(R.id.rv_exercises)

    private val margin by dimensionPixelSize(R.dimen.space_normal)

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate(lifecycleOwner: LifecycleOwner) {
        bindViewModel(lifecycleOwner.lifecycle)
        initViews()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() {
        val lessonId = checkNotNull(activity.extra<String>(LessonActivity.EXTRA.LESSON_ID)) {
            "Extra '${LessonActivity.EXTRA.LESSON_ID}' not set."
        }

        viewModel.dispatch(ActivityResumed(lessonId))
    }

    private fun initViews() {
        activity.setToolbar(toolbar)
        adapter.addWidget { ExerciseListItemWidget() }
        rvExercises.adapter = adapter
        rvExercises.layoutManager = LinearLayoutManager(rvExercises.context)
        rvExercises.addItemDecoration(MarginItemDecoration(margin))
    }

    private fun bindViewModel(lifecycle: Lifecycle) = viewModel.observe(lifecycle) {
        when (it) {
            is UpdateExercises -> updateExercises(it.exercises)
            is ExecuteCommand -> it.command(activity)
            is UpdateLesson -> toolbar.title = it.title
        }
    }

    private fun updateExercises(exercises: List<ExerciseListItem>) {
        adapter.setItems(exercises)
    }
}
