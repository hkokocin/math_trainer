package de.hkokocin.toolkit.android_extensions

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.DisplayMetrics
import java.io.Serializable
import kotlin.reflect.KClass

inline fun <reified T : Activity> Activity.startForResult(
    requestCode: Int,
    init: Intent.() -> Unit = {}
) {
    val intent = Intent(this, T::class.java)
    intent.init()
    startActivityForResult(intent, requestCode)
}

inline fun <reified T : Activity> Activity.startActivity(init: Intent.() -> Unit = {}) {
    val intent = Intent(this, T::class.java)
    startActivity(intent)
}

inline fun <reified T : Any> Activity.extra(name: String) =
    getExtra(intent, name, T::class)

inline fun <reified T : Any> Activity.extra(name: String, default: T) =
    getExtra(intent, name, T::class) ?: default

@Suppress("UNCHECKED_CAST", "RECEIVER_NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
fun <T : Any> getExtra(intent: Intent, name: String, type: KClass<T>): T? = when (type) {
    Char::class -> intent.getCharExtra(name, ' ') as T?
    Array<Char>::class -> intent.getCharArrayExtra(name).toTypedArray() as T?
    CharArray::class -> intent.getCharArrayExtra(name) as T?
    String::class -> intent.getStringExtra(name) as T?
    Array<String>::class -> intent.getStringArrayExtra(name) as T?
    CharSequence::class -> intent.getCharSequenceExtra(name) as T?
    Array<CharSequence>::class -> intent.getCharSequenceArrayExtra(name) as T?
    Short::class -> intent.getShortExtra(name, 0) as T?
    Array<Short>::class -> intent.getShortArrayExtra(name).toTypedArray() as T?
    ShortArray::class -> intent.getShortArrayExtra(name) as T?
    Int::class -> intent.getIntExtra(name, 0) as T?
    Array<Int>::class -> intent.getIntArrayExtra(name).toTypedArray() as T?
    IntArray::class -> intent.getIntArrayExtra(name) as T?
    Long::class -> intent.getLongExtra(name, 0) as T?
    Array<Long>::class -> intent.getLongArrayExtra(name).toTypedArray() as T?
    LongArray::class -> intent.getLongArrayExtra(name) as T?
    Double::class -> intent.getDoubleExtra(name, 0.0) as T?
    Array<Double>::class -> intent.getDoubleArrayExtra(name).toTypedArray() as T?
    DoubleArray::class -> intent.getDoubleArrayExtra(name) as T?
    Float::class -> intent.getFloatExtra(name, 0f) as T?
    Array<Float>::class -> intent.getFloatArrayExtra(name).toTypedArray() as T?
    FloatArray::class -> intent.getFloatArrayExtra(name) as T?
    Boolean::class -> intent.getBooleanExtra(name, false) as T?
    Array<Boolean>::class -> intent.getBooleanArrayExtra(name).toTypedArray() as T?
    BooleanArray::class -> intent.getBooleanArrayExtra(name) as T?
    Byte::class -> intent.getByteExtra(name, 0) as T?
    Array<Byte>::class -> intent.getByteArrayExtra(name).toTypedArray() as T?
    ByteArray::class -> intent.getByteArrayExtra(name) as T?
    Serializable::class -> intent.getSerializableExtra(name) as T?
    Bundle::class -> intent.getBundleExtra(name) as T?
    else -> throw  IllegalArgumentException("cannot get extra of unknown type ${type.java.name}")
}


val Activity.screenMetrics: DisplayMetrics
    get() {
        val metrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(metrics)
        return metrics
    }
