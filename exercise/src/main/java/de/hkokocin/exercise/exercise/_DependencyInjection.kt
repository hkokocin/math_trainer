package de.hkokocin.exercise.exercise

import de.hkokocin.android.BaseActivity
import de.hkokocin.application.activityModule
import de.hkokocin.application.globalScope
import de.hkokocin.toolkit.i
import org.kodein.di.Kodein
import org.kodein.di.erased.bind
import org.kodein.di.erased.provider

fun exerciseScope(activity: BaseActivity) = Kodein {
    import(activity.globalScope.exerciseServiceModule)
    import(activity.globalScope.localDataModule)
    import(activity.globalScope.applicationModule)
    import(activityModule(activity))
    import(exerciseModule())
}

fun exerciseModule() = Kodein.Module("ExerciseModule") {
    bind<ExerciseView>() with provider { ExerciseView(i(), i()) }
    bind<ExerciseViewModel>() with provider { ExerciseViewModel(i(), i(), i()) }
}
