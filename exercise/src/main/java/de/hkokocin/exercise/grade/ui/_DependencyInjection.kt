package de.hkokocin.exercise.grade.ui

import de.hkokocin.exercise_service.grade.Arithmetic
import de.hkokocin.toolkit.i
import de.hkokocin.toolkit.p
import de.hkokocin.widgetadapter.WidgetAdapter
import org.kodein.di.Kodein
import org.kodein.di.erased.bind
import org.kodein.di.erased.provider

fun gradeViewModule() = Kodein.Module("GradeViewModule") {
    bind<WidgetAdapter>() with provider { WidgetAdapter(i()) }
    bind<GradeViewModel>() with provider { GradeViewModel(i(), i(), Arithmetic.ADDITION) }
    bind<GradeView>() with provider { GradeView(i(), i(), i(), p()) }
    bind<ExerciseListItemWidget>() with provider { ExerciseListItemWidget() }
}
