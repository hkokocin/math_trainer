package de.hkokocin.redukt

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModel

interface ViewState

abstract class CompositeViewModel<T : ViewState>(private vararg val shards: ViewModelShard<T>) : ViewModel(), Store<T> {

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

abstract class ViewModelShard<T : Any>() : Store<T> {
    override val subscriptions = mutableListOf<(T) -> Unit>()

    open fun onCleared() {}
}
