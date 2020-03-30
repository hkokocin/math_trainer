package de.hkokocin.android

import android.app.Activity
import android.content.Intent

typealias ActivityCommand = (Activity) -> Unit

inline fun <reified T: Activity> startActivity(noinline init: Intent.() -> Unit = {}): ActivityCommand = {
    val intent = Intent(it, T::class.java)
    intent.init()
    it.startActivity(intent)
}

fun finishActivity(resultCode: Int = Activity.RESULT_OK): ActivityCommand = {
    it.setResult(resultCode)
    it.finish()
}
