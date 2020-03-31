package de.hkokocin.exercise.grade

import android.content.res.ColorStateList
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.widget.ImageViewCompat
import de.hkokocin.exercise.R
import de.hkokocin.widgetadapter.Widget

class LessonNodeWidget : Widget<LessonNodeViewState>(R.layout.lesson_node) {

    private val clContainer: ConstraintLayout by viewId(R.id.cl_container)
    private val tvTitle: TextView by viewId(R.id.tv_title)
    private val ivStar1: ImageView by viewId(R.id.iv_star1)
    private val ivStar2: ImageView by viewId(R.id.iv_star2)
    private val ivStar3: ImageView by viewId(R.id.iv_star3)

    private val inactiveColor by colorResource(R.color.primary_dark)
    private val activeColor by colorResource(R.color.accent)

    override fun setData(data: LessonNodeViewState) {
        tvTitle.text = data.title

        ivStar1.setStarColor(data.stars >= 1)
        ivStar2.setStarColor(data.stars >= 2)
        ivStar3.setStarColor(data.stars >= 3)

        clContainer.setOnClickListener { data.onClick() }
    }

    private fun ImageView.setStarColor(active: Boolean) {
        val color = if (active) activeColor else inactiveColor
        ImageViewCompat.setImageTintList(this, ColorStateList.valueOf(color));
    }
}