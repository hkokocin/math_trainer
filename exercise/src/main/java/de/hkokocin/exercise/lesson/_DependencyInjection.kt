package de.hkokocin.exercise.lesson

import androidx.lifecycle.ViewModel
import de.hkokocin.android.BaseActivity
import de.hkokocin.application.activityModule
import de.hkokocin.application.globalScope
import de.hkokocin.toolkit.i
import de.hkokocin.uikit.bindViewModels
import de.hkokocin.widgetadapter.WidgetAdapter
import org.kodein.di.Kodein
import org.kodein.di.bindings.NoArgSimpleBindingKodein
import org.kodein.di.erased.bind
import org.kodein.di.erased.provider
import kotlin.reflect.KClass

fun lessonScope(activity: BaseActivity) = Kodein {
    import(activity.globalScope.applicationModule)
    import(activity.globalScope.exerciseServiceModule)
    import(activity.globalScope.localDataModule)

    import(activityModule(activity))
    import(lessonModule(activity))
}

fun lessonModule(activity: BaseActivity) = Kodein.Module("ExerciseModule") {
    bind<WidgetAdapter>() with provider { WidgetAdapter(i()) }
    bind<LessonView>() with provider { LessonView(i(), i(), i()) }

    bind<LoadExerciseListUseCase>() with provider { LoadExerciseListUseCase(i(), i()) }
    bind<LessonViewModelShard>() with provider { LessonViewModelShard(i(), i(), i()) }

    val providers = mutableMapOf<KClass<out ViewModel>, NoArgSimpleBindingKodein<*>.() -> ViewModel>()
    providers[LessonViewModel::class] = { LessonViewModel(i()) }

    bindViewModels(activity, providers)
}
