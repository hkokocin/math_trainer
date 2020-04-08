package de.hkokocin.application

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import de.hkokocin.exercise_service.exerciseServiceModule
import de.hkokocin.local_data.localDataModule
import timber.log.Timber

class MathTrainerApplication: Application() {
    val globalScope = GlobalScope(this)

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}

class GlobalScope(application: MathTrainerApplication) {
    val applicationModule by lazy { applicationModule(application) }
    val exerciseServiceModule by lazy { exerciseServiceModule() }
    val localDataModule by lazy { localDataModule() }
}

val AppCompatActivity.globalScope get() = (application as MathTrainerApplication).globalScope
