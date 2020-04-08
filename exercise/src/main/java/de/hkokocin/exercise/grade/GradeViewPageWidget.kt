package de.hkokocin.exercise.grade

import android.graphics.drawable.Drawable
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import com.google.android.material.textview.MaterialTextView
import de.hkokocin.exercise.R
import de.hkokocin.widgetadapter.Widget

private data class ViewHolder(
    val vTrackTo: View,
    val vTrackFrom: View,
    val flContainer: FrameLayout,
    val vProgress: View,
    val tvTitle: MaterialTextView,
    val tvProgressLabel: MaterialTextView
)

class GradeViewPageWidget() : Widget<GradeViewPageState>(R.layout.grade_view_page) {

    private val addViews by lazy {
        ViewHolder(
            view.findViewById(R.id.v_track_to_add),
            view.findViewById(R.id.v_track_from_add),
            view.findViewById(R.id.fl_add),
            view.findViewById(R.id.v_add_progress),
            view.findViewById(R.id.tv_add_title),
            view.findViewById(R.id.tv_add_progress_label)
        )
    }

    private val subtractViews by lazy {
        ViewHolder(
            view.findViewById(R.id.v_track_to_subtract),
            view.findViewById(R.id.v_track_from_subtract),
            view.findViewById(R.id.fl_subtract),
            view.findViewById(R.id.v_subtract_progress),
            view.findViewById(R.id.tv_subtract_title),
            view.findViewById(R.id.tv_subtract_progress_label)
        )
    }

    private val multiplyViews by lazy {
        ViewHolder(
            view.findViewById(R.id.v_track_to_multiply),
            view.findViewById(R.id.v_track_from_multiply),
            view.findViewById(R.id.fl_multiply),
            view.findViewById(R.id.v_multiply_progress),
            view.findViewById(R.id.tv_multiply_title),
            view.findViewById(R.id.tv_multiply_progress_label)
        )
    }

    private val divideViews by lazy {
        ViewHolder(
            view.findViewById(R.id.v_track_to_divide),
            view.findViewById(R.id.v_track_from_divide),
            view.findViewById(R.id.fl_divide),
            view.findViewById(R.id.v_divide_progress),
            view.findViewById(R.id.tv_divide_title),
            view.findViewById(R.id.tv_divide_progress_label)
        )
    }

    private val tvGrade: MaterialTextView by viewId(R.id.tv_grade)
    private val tvStarsCollected: MaterialTextView by viewId(R.id.tv_stars_collected)
    private val tvStarsRemaining: MaterialTextView by viewId(R.id.tv_stars_left)
    private val tvStarsToNextLevel: MaterialTextView by viewId(R.id.tv_stars_to_next_level)
    private val ivLock: ImageView by viewId(R.id.iv_lock)
    private val llLevel: LinearLayout by viewId(R.id.ll_level)

    private val labelLessonProgress: String by resourceId(R.string.lesson_item_progress)
    private val labelStarsCollected: String by resourceId(R.string.grade_stars_collected)
    private val labelStarsRemaining: String by resourceId(R.string.grade_stars_remaining)
    private val labelStarsToNextLevel: String by resourceId(R.string.grade_stars_to_next_level)

    private val icLocked: Drawable by resourceId(R.drawable.ic_locked_24dp)
    private val icUnlocked: Drawable by resourceId(R.drawable.ic_unlocked_24dp)

    override fun onViewCreated(view: View) {
        addViews.flContainer.clipToOutline = true
        subtractViews.flContainer.clipToOutline = true
        multiplyViews.flContainer.clipToOutline = true
        divideViews.flContainer.clipToOutline = true
    }

    override fun setData(data: GradeViewPageState) {
        tvGrade.text = data.index.inc().toString()
        tvStarsCollected.text = labelStarsCollected.format(data.starsCollected)
        tvStarsRemaining.text = labelStarsRemaining.format(data.starsRemaining)
        tvStarsToNextLevel.text = labelStarsToNextLevel.format(data.starsToNextLevel, data.index + 2)

        val lockIcon = if (data.starsToNextLevel == 0) icUnlocked else icLocked
        tvStarsToNextLevel.setCompoundDrawablesWithIntrinsicBounds(lockIcon, null, null, null)

        llLevel.isInvisible = data.unlocked.not()
        tvStarsCollected.isInvisible = data.unlocked.not()
        tvStarsRemaining.isInvisible = data.unlocked.not()
        tvStarsToNextLevel.isInvisible = data.unlocked.not()
        ivLock.isVisible = data.unlocked.not()

        data.addLesson.applyTo(addViews, data.unlocked)
        data.subtractLesson.applyTo(subtractViews, data.unlocked)
        data.multiplyLesson.applyTo(multiplyViews, data.unlocked)
        data.divideLesson.applyTo(divideViews, data.unlocked)
    }

    private fun LessonState?.applyTo(viewHolder: ViewHolder, unlocked: Boolean) {
        if (this == null || unlocked.not()) {
            viewHolder.flContainer.isInvisible = true
            return
        }

        viewHolder.tvTitle.text = title
        viewHolder.tvProgressLabel.text = labelLessonProgress.format(progressStars, totalStars)
        viewHolder.vTrackTo.isVisible = showTrackToItem
        viewHolder.vTrackFrom.isVisible = showTrackFromItem
        viewHolder.vProgress.post {
            val width = viewHolder.vProgress.width
            viewHolder.vProgress.translationX = -width + width * progressStars / totalStars.toFloat()
        }
        viewHolder.flContainer.isInvisible = false
        viewHolder.flContainer.setOnClickListener { onClick() }
    }
}
