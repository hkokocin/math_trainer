package de.hkokocin.exercise.grade

import de.hkokocin.android.BaseActivity
import de.hkokocin.application.activityModule
import de.hkokocin.application.globalScope
import de.hkokocin.exercise.grade.domain.gradeDomainModule
import de.hkokocin.exercise.grade.ui.gradeViewModule
import org.kodein.di.Kodein


fun gradeScope(activity: BaseActivity) = Kodein {
    import(activity.globalScope.localDataModule)
    import(activity.globalScope.applicationModule)
    import(activity.globalScope.exerciseServiceModule)
    import(activityModule(activity))

    import(gradeDomainModule())
    import(gradeViewModule())
}
