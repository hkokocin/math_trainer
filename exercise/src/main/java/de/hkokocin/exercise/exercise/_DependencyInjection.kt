package de.hkokocin.exercise.exercise

import androidx.lifecycle.ViewModel
import de.hkokocin.android.BaseActivity
import de.hkokocin.application.activityModule
import de.hkokocin.application.globalScope
import de.hkokocin.toolkit.coroutines.coroutinesModule
import de.hkokocin.toolkit.i
import de.hkokocin.uikit.bindViewModels
import org.kodein.di.Kodein
import org.kodein.di.bindings.NoArgSimpleBindingKodein
import org.kodein.di.erased.bind
import org.kodein.di.erased.instance
import org.kodein.di.erased.provider
import kotlin.reflect.KClass

fun exerciseScope(activity: BaseActivity) = Kodein {
    import(activity.globalScope.exerciseServiceModule)
    import(activity.globalScope.localDataModule)
    import(activity.globalScope.applicationModule)
    import(activityModule(activity))
    import(exerciseModule(activity))
}

fun exerciseModule(activity: BaseActivity) = Kodein.Module("ExerciseModule") {
    bind<ExerciseView>() with provider { ExerciseView(i(), i()) }
    bind<ExerciseViewModelShard>() with provider { ExerciseViewModelShard(i(), i(), i()) }

    val providers = mutableMapOf<KClass<out ViewModel>, NoArgSimpleBindingKodein<*>.() -> ViewModel>()
    providers[ExerciseViewModel::class] = { ExerciseViewModel(i()) }

    bindViewModels(activity, providers)
}
