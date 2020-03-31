package de.hkokocin.exercise.grade

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import de.blox.graphview.BaseGraphAdapter
import de.blox.graphview.ViewHolder
import de.hkokocin.exercise.R
import de.hkokocin.widgetadapter.Widget
import de.hkokocin.widgetadapter.WidgetViewHolder
import java.util.LinkedHashMap

class GraphViewWidgetViewHolder<T>(val widget: Widget<T>, view: View) : ViewHolder(view)


class GraphViewWidgetAdapter(
    private val layoutInflater: LayoutInflater
) : BaseGraphAdapter<ViewHolder>() {

    var widgetProviders = LinkedHashMap<Class<out Any>, () -> Widget<*>>()

    inline fun <reified T : Any> addWidget(noinline widgetProvider: () -> Widget<T>) {
        widgetProviders[T::class.java] = widgetProvider
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val provider = widgetProviders.values.elementAt(viewType)
        val widget = provider()
        return GraphViewWidgetViewHolder(widget, widget.createView(layoutInflater, parent))
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, data: Any, position: Int) {
        bindViewHolder(viewHolder, data)
    }

    @Suppress("UNCHECKED_CAST")
    private fun <T> bindViewHolder(holder: ViewHolder, item: T) {
        (holder as GraphViewWidgetViewHolder<T>).widget.apply {
            setData(item)
            onViewBound()
        }
    }
}
