package de.hkokocin.redukt

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

interface Action

interface LifecycleAwareObservable<T> {

    val subscriptions: MutableList<(T) -> Unit>

    fun dispatch(action: Action)

    /**
     * Add an observer that has to be cleaned up manually. You can do so by invoking the returned function.
     */
    fun observeForever(observer: (T) -> Unit): () -> Unit {
        subscriptions.add(observer)
        return { subscriptions.remove(observer) }
    }

    /**
     * Add an observer that is automatically cleaned up if the lifecycle sends onDestroy
     */
    fun observe(lifecycle: Lifecycle, observer: (T) -> Unit) {
        lifecycle.addObserver(LifecycleAwareSubscription(observer, subscriptions))
        subscriptions.add(observer)
    }

    fun emit(state: T) = subscriptions.forEach { it(state) }
}

private class LifecycleAwareSubscription<T>(
    private val subscription: (T) -> Unit,
    private val subscriptions: MutableList<(T) -> Unit>
) : LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun unsubscribe() {
        subscriptions.remove(subscription)
    }
}
