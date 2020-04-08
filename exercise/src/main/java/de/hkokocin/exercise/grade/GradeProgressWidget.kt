package de.hkokocin.exercise.grade

import android.annotation.SuppressLint
import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.google.android.material.textview.MaterialTextView
import de.hkokocin.exercise.R
import de.hkokocin.widgetadapter.Widget

class GradeProgressWidget() : Widget<GradeProgressWidgetState>(R.layout.grade_widget) {

    private val tvProgress: MaterialTextView by viewId(R.id.tv_progress)
    private val ivIcon: ImageView by viewId(R.id.iv_icon)

    private val lockIcon by resourceId<Drawable>(R.drawable.ic_lock_black)
    private val starIcon by resourceId<Drawable>(R.drawable.ic_star_96dp)

    @SuppressLint("SetTextI18n")
    override fun setData(data: GradeProgressWidgetState) {
        tvProgress.text = "${data.progressStars}/${data.totalStars}"
        ivIcon.setImageDrawable(if (data.unlocked) starIcon else lockIcon)
    }
}
