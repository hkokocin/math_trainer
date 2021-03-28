package de.hkokocin.exercise.grade.ui

import android.content.res.ColorStateList
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.widget.ImageViewCompat
import de.hkokocin.exercise.R
import de.hkokocin.toolkit.android_extensions.attributeColor
import de.hkokocin.widgetadapter.Widget

class ExerciseListItemWidget : Widget<ExerciseListItem>(R.layout.exercise_item) {

    private val clContainer: ConstraintLayout by viewId(R.id.cl_container)
    private val tvTitle: TextView by viewId(R.id.tv_title)
    private val ivStar1: ImageView by viewId(R.id.iv_star1)
    private val ivStar2: ImageView by viewId(R.id.iv_star2)
    private val ivStar3: ImageView by viewId(R.id.iv_star3)

    private val inactiveColor by lazy { view.context.attributeColor(R.attr.colorPrimaryDark) }
    private val activeColor by colorResource(R.color.amber)

    override fun setData(data: ExerciseListItem) {
        tvTitle.text = data.title

        ivStar1.setStarColor(data.stars >= 1)
        ivStar2.setStarColor(data.stars >= 2)
        ivStar3.setStarColor(data.stars >= 3)

        clContainer.isEnabled = data.unlocked
        clContainer.setOnClickListener { data.onClick() }

//        clContainer.postDelayed({
        clContainer.alpha = if (data.unlocked) 1f else 0.3f
//        }, 480)
    }

    private fun ImageView.setStarColor(active: Boolean) {
        val color = if (active) activeColor else inactiveColor
        ImageViewCompat.setImageTintList(this, ColorStateList.valueOf(color));
    }
}
