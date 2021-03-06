package de.hkokocin.toolkit.android_extensions

import android.app.Activity
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Vibrator
import android.util.TypedValue
import androidx.annotation.AnyRes
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat

inline fun <reified T : Activity> Context.start(noinline init: Intent.() -> Unit = {}) {
    val intent = Intent(this, T::class.java)
    intent.init()
    startActivity(intent)
}

inline fun Context.alertDialog(init: AlertDialog.Builder.() -> Unit): AlertDialog {
    val builder = AlertDialog.Builder(this)
    builder.init()
    return builder.show()
}

val Context.notificationManager get() = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
val Context.vibrator get() = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator

inline fun <reified T : Any> Context.getAnyResource(@AnyRes resourceId: Int) = when (T::class) {
    String::class -> resources.getString(resourceId) as T
    Array<String>::class -> resources.getStringArray(resourceId) as T
    CharSequence::class -> resources.getText(resourceId) as T
    Array<CharSequence>::class -> resources.getTextArray(resourceId) as T
    Int::class -> resources.getInteger(resourceId) as T
    Array<Int>::class -> resources.getIntArray(resourceId).toTypedArray() as T
    Boolean::class -> resources.getBoolean(resourceId) as T
    Drawable::class -> ContextCompat.getDrawable(this, resourceId) as T
    else -> throw IllegalArgumentException("cannot get resource of unknown type: ${T::class.java.simpleName}")
}

fun Context.attributeColor(attr: Int): Int {
    val value = TypedValue()
    theme.resolveAttribute(attr, value, true);
    return value.data
}
