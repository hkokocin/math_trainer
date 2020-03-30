package de.hkokocin.redukt

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.View
import androidx.annotation.AnyRes
import androidx.annotation.DimenRes
import androidx.annotation.IdRes
import androidx.core.content.ContextCompat
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver

abstract class BaseView : LifecycleObserver {

    protected lateinit var root: View

    val context: Context
        get() = root.context

    fun setRootView(view: View) {
        root = view
        onViewCreated()
    }

    fun bindToLifecycle(lifecycle: Lifecycle) {
        lifecycle.addObserver(this)
    }

    protected open fun onViewCreated() {}

    protected fun <T : View> viewId(@IdRes id: Int): Lazy<T> = lazy { root.findViewById<T>(id) }

    private fun <T : View> findViewId(@IdRes id: Int): T? = root.findViewById(id)

    protected inline fun <reified T : Any> resourceId(@AnyRes id: Int) = lazy { getAnyResource<T>(context, id) }

    protected inline fun <reified T : Any> getResource(@AnyRes id: Int) = getAnyResource<T>(context, id)

    protected fun dimensionPixelSize(@DimenRes id: Int) = lazy { root.resources.getDimensionPixelSize(id) }
}

@Suppress("UNCHECKED_CAST", "IMPLICIT_CAST_TO_ANY")
inline fun <reified T : Any> getAnyResource(context: Context, @AnyRes resourceId: Int): T = when (T::class) {
    String::class -> context.resources.getString(resourceId)
    Array<String>::class -> context.resources.getStringArray(resourceId)
    CharSequence::class -> context.resources.getText(resourceId)
    Array<CharSequence>::class -> context.resources.getTextArray(resourceId)
    Int::class -> context.resources.getInteger(resourceId)
    Array<Int>::class -> context.resources.getIntArray(resourceId).toTypedArray()
    Boolean::class -> context.resources.getBoolean(resourceId)
    Drawable::class -> ContextCompat.getDrawable(context, resourceId)
    else -> throw IllegalArgumentException("cannot get resource of unknown type: ${T::class.java.simpleName}")
} as T

