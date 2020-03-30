package de.hkokocin.application

import android.app.Activity
import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import de.hkokocin.android.BaseActivity
import de.hkokocin.toolkit.coroutines.coroutinesModule
import org.kodein.di.Kodein
import org.kodein.di.erased.bind
import org.kodein.di.erased.instance
import org.kodein.di.erased.singleton

private const val APPLICATION_PREFERENCES = "APPLICATION_PREFERENCES"

internal fun applicationModule(app: MathTrainerApplication) = Kodein.Module("ApplicationModule") {
    bind<Application>() with singleton { app }
    bind<SharedPreferences>() with singleton {
        app.getSharedPreferences(APPLICATION_PREFERENCES, Context.MODE_PRIVATE)
    }
}

fun activityModule(activity: BaseActivity) = Kodein.Module("application.activity") {
    import(coroutinesModule())

    bind<LayoutInflater>() with instance(activity.layoutInflater)
    bind<BaseActivity>() with instance(activity)
    bind<AppCompatActivity>() with instance(activity)
    bind<Activity>() with instance(activity)
}
