package de.hkokocin.exercise.grade

import android.view.Gravity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent
import com.otaliastudios.zoom.ZoomApi
import de.blox.graphview.GraphView
import de.blox.graphview.layered.SugiyamaAlgorithm
import de.blox.graphview.layered.SugiyamaConfiguration
import de.hkokocin.android.BaseActivity
import de.hkokocin.exercise.R
import de.hkokocin.exercise.grade.GradeTreeViewState.Command
import de.hkokocin.exercise.grade.GradeTreeViewState.UpdateGraph
import de.hkokocin.redukt.BaseView


class GradeTreeView(
    private val viewModel: GradeTreeViewModel,
    private val adapter: GraphViewWidgetAdapter,
    private val activity: BaseActivity
) : BaseView() {

    val gvGrades: GraphView by viewId(R.id.gv_grades)

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate(lifecycleOwner: LifecycleOwner) {
        bindViews()
        bindViewModel(lifecycleOwner.lifecycle)
        viewModel.dispatch(ViewCreated)
    }

    private fun bindViews() {
        adapter.addWidget { LessonNodeWidget() }
        gvGrades.adapter = adapter
        gvGrades.setUseMaxSize(true)
        gvGrades.engine.setTransformation(ZoomApi.TRANSFORMATION_NONE, Gravity.CENTER_HORIZONTAL)
        adapter.algorithm = createGraphAlgorithm()
    }

    private fun createGraphAlgorithm() = SugiyamaAlgorithm(
        SugiyamaConfiguration(
            SugiyamaConfiguration.Builder()
                .setLevelSeparation(150)
                .setNodeSeparation(150)
        )
    )
//
//    private fun createGraphAlgorithm() = BuchheimWalkerAlgorithm(
//        BuchheimWalkerConfiguration.Builder()
//            .setSiblingSeparation(100)
//            .setLevelSeparation(150)
//            .setSubtreeSeparation(100)
//            .setOrientation(BuchheimWalkerConfiguration.ORIENTATION_TOP_BOTTOM)
//            .build()
//    )

    private fun bindViewModel(lifecycle: Lifecycle) = viewModel.observe(lifecycle) {
        when (it) {
            is UpdateGraph -> adapter.graph = it.graph
            is Command -> it.command(activity)
        }
    }
}
