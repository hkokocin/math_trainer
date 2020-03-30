package de.hkokocin.uikit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import org.kodein.di.Kodein
import org.kodein.di.TT
import org.kodein.di.bindings.NoArgBindingKodein
import org.kodein.di.bindings.NoArgSimpleBindingKodein
import org.kodein.di.erased.bind
import org.kodein.di.erased.instance
import org.kodein.di.erased.provider
import org.kodein.di.erased.singleton
import kotlin.reflect.KClass

fun Kodein.Builder.bindViewModels(
    viewModelStoreOwner: ViewModelStoreOwner,
    providers: Map<KClass<out ViewModel>, NoArgSimpleBindingKodein<*>.() -> ViewModel>
) {

    bind<ViewModelProvider.Factory>() with singleton { ViewModelFactory(this, providers) }

    providers.keys.forEach { type ->
        Bind(TT(type)) with provider {
            ViewModelProvider(viewModelStoreOwner, instance()).get(type.java)
        }
    }
}

class ViewModelFactory(
    private val binding: NoArgSimpleBindingKodein<Any?>,
    private val providers: Map<KClass<out ViewModel>, NoArgSimpleBindingKodein<*>.() -> ViewModel>
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST", "TYPE_INFERENCE_ONLY_INPUT_TYPES_WARNING")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val provider = checkNotNull(providers[modelClass.kotlin]) { "No ViewModel provider found for ${modelClass.name}" }
        return binding.provider() as T
    }
}
