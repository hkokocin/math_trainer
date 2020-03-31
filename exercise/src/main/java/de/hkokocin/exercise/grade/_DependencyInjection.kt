package de.hkokocin.exercise.grade

import androidx.lifecycle.ViewModel
import de.hkokocin.android.BaseActivity
import de.hkokocin.application.activityModule
import de.hkokocin.application.globalScope
import de.hkokocin.toolkit.i
import de.hkokocin.uikit.bindViewModels
import org.kodein.di.Kodein
import org.kodein.di.bindings.NoArgSimpleBindingKodein
import org.kodein.di.erased.bind
import org.kodein.di.erased.provider
import kotlin.reflect.KClass


fun gradeScope(activity: BaseActivity) = Kodein {
    import(activity.globalScope.exerciseServiceModule)
    import(activity.globalScope.localDataModule)
    import(activity.globalScope.applicationModule)
    import(activityModule(activity))
    import(gradeModule(activity))
}

fun gradeModule(activity: BaseActivity) = Kodein.Module("ExerciseModule") {
    bind<GraphViewWidgetAdapter>() with provider { GraphViewWidgetAdapter(i()) }
    bind<GradeTreeView>() with provider { GradeTreeView(i(), i(), i()) }
    bind<GradeTreeViewModelShard>() with provider { GradeTreeViewModelShard(i(), i(), i()) }

    val providers = mutableMapOf<KClass<out ViewModel>, NoArgSimpleBindingKodein<*>.() -> ViewModel>()
    providers[GradeTreeViewModel::class] = { GradeTreeViewModel(i()) }

    bindViewModels(activity, providers)
}
