package de.hkokocin.widgetadapter

interface CollapsableWidgetData {
    val collapsableGroupId: String
}

interface CollapsableGroupHeaderWidgetData {
    val collapsableGroupId: String
    val isCollapsed: Boolean
}
