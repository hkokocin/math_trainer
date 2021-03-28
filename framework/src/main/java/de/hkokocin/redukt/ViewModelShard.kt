package de.hkokocin.redukt

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModel

interface ViewState

abstract class ObservableViewModel<T : ViewState>() : LifecycleAwareObservable<T> {
    override val subscriptions = mutableListOf<(T) -> Unit>()
}

@Deprecated("If classes are so tightly coupled that they do not work alone they meight as well be one class. We need to separate on another level")
abstract class CompositeViewModel<T : ViewState>(private vararg val shards: ViewModelShard<T>) : ViewModel(),
    LifecycleAwareObservable<T> {

    override val subscriptions = mutableListOf<(T) -> Unit>()

    override fun observeForever(observer: (T) -> Unit): () -> Unit {
        val unSubscribers = shards.map { it.observeForever(observer) }
        return { unSubscribers.forEach { it() } }
    }

    override fun observe(lifecycle: Lifecycle, observer: (T) -> Unit) {
        shards.forEach { it.observe(lifecycle, observer) }
    }

    override fun dispatch(action: Action) {
        shards.forEach { it.dispatch(action) }
    }
}

abstract class ViewModelShard<T : Any>() : LifecycleAwareObservable<T> {
    override val subscriptions = mutableListOf<(T) -> Unit>()

    open fun onCleared() {}
}
