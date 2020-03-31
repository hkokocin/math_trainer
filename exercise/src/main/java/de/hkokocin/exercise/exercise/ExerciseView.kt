package de.hkokocin.exercise.exercise

import android.animation.ValueAnimator
import android.annotation.SuppressLint
import android.os.VibrationEffect
import android.view.View
import android.view.animation.*
import android.widget.Button
import android.widget.ImageView
import android.widget.ScrollView
import android.widget.TextView
import androidx.core.animation.addListener
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent
import com.google.android.material.appbar.MaterialToolbar
import de.hkokocin.android.BaseActivity
import de.hkokocin.exercise.R
import de.hkokocin.exercise.exercise.ExerciseActivity.EXTRA.EXERCISE_DEFINITION_ID
import de.hkokocin.exercise.exercise.ExerciseViewState.*
import de.hkokocin.exercise.exercise.ViewLayer.*
import de.hkokocin.redukt.BaseView
import de.hkokocin.toolkit.android_extensions.extra
import de.hkokocin.toolkit.android_extensions.screenMetrics
import de.hkokocin.toolkit.android_extensions.start
import de.hkokocin.toolkit.android_extensions.vibrator
import de.hkokocin.uikit.setToolbar

enum class ViewLayer {
    START, IN_PROGESS, RESULT
}

object AnimationDuration {
    const val ERROR = 2000L
    const val SHORT = 100L
}

object VibrationDuration{
    const val SHORT = 20L
    const val LONG = 1200L
}

class ExerciseView(
    private val viewModel: ExerciseViewModel,
    private val activity: BaseActivity
) : BaseView() {

    private val toolbar: MaterialToolbar by viewId(R.id.toolbar)
    private val vProgressOverlay: View by viewId(R.id.v_progress_overlay)

    private val bStart: Button by viewId(R.id.b_start)
    private val svIntroduction: ScrollView by viewId(R.id.sv_introduction)
    private val tvTitle: TextView by viewId(R.id.tv_title)
    private val tvHighscore: TextView by viewId(R.id.tv_highscore)
    private val tvDescription: TextView by viewId(R.id.tv_description)
    private val startViews by lazy { listOf(bStart, svIntroduction) }

    private val tvProblem: TextView by viewId(R.id.tv_problem)
    private val bOption1: Button by viewId(R.id.b_option1)
    private val bOption2: Button by viewId(R.id.b_option2)
    private val bOption3: Button by viewId(R.id.b_option3)
    private val problemViews by lazy { listOf(tvProblem, bOption1, bOption2, bOption3) }

    private val tvScore: TextView by viewId(R.id.tv_score)
    private val ivStar1: ImageView by viewId(R.id.iv_star1)
    private val ivStar2: ImageView by viewId(R.id.iv_star2)
    private val ivStar3: ImageView by viewId(R.id.iv_star3)
    private val bBack: Button by viewId(R.id.b_back)
    private val bRestart: Button by viewId(R.id.b_restart)
    private val resultViews by lazy { listOf(ivStar1, ivStar2, ivStar3, bRestart, bBack) }

    private val translationOffset by lazy { activity.screenMetrics.heightPixels - bOption1.y }

    private val scoreLabel: String by resourceId(R.string.score)
    private val highscoreLabel: String by resourceId(R.string.highscore)

    // ==============================================================================
    // INITIALIZATION
    // ==============================================================================

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate(lifecycleOwner: LifecycleOwner) {
        initViews()
        bindViewModel(lifecycleOwner)
        loadParameters()
    }

    private fun initViews() {
        activity.setToolbar(toolbar)
        activity.title = ""
        bOption1.setOnClickListener { viewModel.dispatch(SelectOption(0)) }
        bOption2.setOnClickListener { viewModel.dispatch(SelectOption(1)) }
        bOption3.setOnClickListener { viewModel.dispatch(SelectOption(2)) }
        bStart.setOnClickListener { viewModel.dispatch(StartExercise) }
        bRestart.setOnClickListener { restart() }
        bBack.setOnClickListener { activity.finish() }
    }

    private fun loadParameters() {
        val exerciseId: String = checkNotNull(activity.extra(EXERCISE_DEFINITION_ID)) {
            "ExerciseDefinitionId not set"
        }

        viewModel.dispatch(InitializeExercise(exerciseId))
    }

    // ==============================================================================
    // UPDATES
    // ==============================================================================

    private fun bindViewModel(lifecycleOwner: LifecycleOwner) = viewModel.observe(lifecycleOwner.lifecycle) { update ->
        when (update) {
            is Initialization -> initialize(update)
            is Start -> startExercise(update)
            is NewProblem -> newProblem(update)
            is Result -> result(update)
        }
    }

    private fun initialize(initialization: Initialization) {
        showViews(START)
        tvTitle.text = initialization.title
        tvHighscore.text = highscoreLabel.format(initialization.highscore)
        tvDescription.text = initialization.description
        root.post { vProgressOverlay.translationY = -vProgressOverlay.height.toFloat() }
    }

    private fun startExercise(exerciseStart: Start) {
        showViews(IN_PROGESS)
        vProgressOverlay.animateProgress(exerciseStart.duration * 1000L)
    }

    private fun newProblem(newProblem: NewProblem) = root.post {
        val onOptionViewsHidden: () -> Unit = {
            tvProblem.text = newProblem.problem
            bOption1.text = newProblem.option1
            bOption2.text = newProblem.option2
            bOption3.text = newProblem.option3
            showProblemViewsAnimated()
        }

        when (newProblem.animate) {
            NewProblem.Animate.ERROR -> hideProblemViewsOnErrorAnimated(onOptionViewsHidden)
            NewProblem.Animate.SUCCESS -> hideProblemViewsAnimated(onOptionViewsHidden)
            NewProblem.Animate.START -> {
                hideProblemViews(onOptionViewsHidden)
                showProblemViewsAnimated()
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun result(result: Result) {
        hideProblemViewsAnimated {
            showViews(RESULT)
            showResultViewsAnimated()

            ivStar1.setImageResource(if (result.stars >= 1) R.drawable.ic_star_96dp else R.drawable.ic_star_border_96dp)
            ivStar2.setImageResource(if (result.stars >= 2) R.drawable.ic_star_96dp else R.drawable.ic_star_border_96dp)
            ivStar3.setImageResource(if (result.stars >= 3) R.drawable.ic_star_96dp else R.drawable.ic_star_border_96dp)

            tvScore.text = "${result.score} $scoreLabel"
        }
    }

    // ==============================================================================
    // HELPERS
    // ==============================================================================

    private fun showViews(layer: ViewLayer) {
        startViews.forEach { it.isVisible = layer == START }
        problemViews.forEach { it.isVisible = layer == IN_PROGESS }
        resultViews.forEach { it.isVisible = layer == RESULT }
    }

    private fun restart() {
        activity.start<ExerciseActivity>{
            putExtra(EXERCISE_DEFINITION_ID, activity.extra<String>(EXERCISE_DEFINITION_ID))
        }
        activity.finish()
    }

    private fun showProblemViewsAnimated() {
        tvProblem.fadeIn()
        bOption1.showBottomButtonAnimated()
        bOption2.showBottomButtonAnimated(100)
        bOption3.showBottomButtonAnimated(200)
    }

    @Suppress("DEPRECATION")
    private fun hideProblemViewsAnimated(onEnd: () -> Unit = {}) {
        activity.vibrator.vibrate(VibrationDuration.SHORT)
        tvProblem.fadeOut()
        bOption1.hideOptionAnimated()
        bOption2.hideOptionAnimated(100)
        bOption3.hideOptionAnimated(200, onEnd)
    }

    private fun hideProblemViews(onOptionViewsHidden: () -> Unit = {}) {
        bOption1.translationY = translationOffset
        bOption2.translationY = translationOffset
        bOption3.translationY = translationOffset
        onOptionViewsHidden()
    }

    @Suppress("DEPRECATION")
    private fun hideProblemViewsOnErrorAnimated(onEnd: () -> Unit = {}) {
        activity.vibrator.vibrate(VibrationDuration.LONG)
        tvProblem.fadeOut().startDelay = AnimationDuration.ERROR - AnimationDuration.SHORT
        bOption1.hideOptionOnErrorAnimated()
        bOption2.hideOptionOnErrorAnimated()
        bOption3.hideOptionOnErrorAnimated(onEnd)
    }

    private fun showResultViewsAnimated() {
        ivStar1.showStarAnimated()
        ivStar2.showStarAnimated()
        ivStar3.showStarAnimated()
        tvScore.fadeIn()
        bRestart.translationY = translationOffset
        bRestart.showBottomButtonAnimated(2100)
        bBack.translationY = translationOffset
        bBack.showBottomButtonAnimated(2000)
    }

    // ==============================================================================
    // ANIMATION
    // ==============================================================================

    private fun View.fadeIn() = ValueAnimator.ofFloat(0f, 1f).apply {
        duration = AnimationDuration.SHORT
        interpolator = AccelerateDecelerateInterpolator()
        addUpdateListener { alpha = it.animatedValue as Float }
        start()
    }

    private fun View.fadeOut() = ValueAnimator.ofFloat(1f, 0f).apply {
        duration = AnimationDuration.SHORT
        interpolator = AccelerateDecelerateInterpolator()
        addUpdateListener { alpha = it.animatedValue as Float }
        start()
    }

    private fun View.showBottomButtonAnimated(delay: Long = 0L) {
        ValueAnimator.ofFloat(translationOffset, 0f).apply {
            duration = AnimationDuration.SHORT
            interpolator = DecelerateInterpolator()
            startDelay = delay
            addUpdateListener { translationY = it.animatedValue as Float }
            start()
        }
    }

    private fun View.animateProgress(progressDuration: Long) {
        ValueAnimator.ofFloat(-vProgressOverlay.height.toFloat(), 0f).apply {
            duration = progressDuration
            interpolator = LinearInterpolator()
            addUpdateListener { translationY = it.animatedValue as Float }

            start()
        }
    }

    private fun View.hideOptionAnimated(
        delay: Long = 0L,
        onEnd: () -> Unit = {}
    ) {
        isEnabled = false
        ValueAnimator.ofFloat(0f, translationOffset).apply {
            duration = AnimationDuration.SHORT
            interpolator = AccelerateInterpolator()
            startDelay = delay
            addUpdateListener { translationY = it.animatedValue as Float }
            addListener(onEnd = {
                isEnabled = true
                onEnd()
            })

            start()
        }
    }

    private fun View.hideOptionOnErrorAnimated(onEnd: () -> Unit = {}) {
        isEnabled = false
        setBackgroundColor(resources.getColor(R.color.error))
        ValueAnimator.ofFloat(1f, 0f).apply {
            duration = AnimationDuration.ERROR
            interpolator = DecelerateInterpolator()
            addUpdateListener {
                scaleX = it.animatedValue as Float
                scaleY = it.animatedValue as Float
            }
            addListener(onEnd = {
                scaleX = 1f
                scaleY = 1f
                translationY = translationOffset
                setBackgroundColor(resources.getColor(R.color.accent))
                isEnabled = true
                onEnd()
            })

            start()
        }
    }

    private fun View.showStarAnimated() {
        scaleX = 0f
        scaleY = 0f

        ValueAnimator.ofFloat(0f, 1f).apply {
            duration = 1000
            interpolator = BounceInterpolator()
            addUpdateListener {
                scaleX = it.animatedValue as Float
                scaleY = it.animatedValue as Float
            }
            start()
        }
    }
}
