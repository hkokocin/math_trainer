package de.hkokocin.uikit

import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.appbar.MaterialToolbar

fun AppCompatActivity.setToolbar(toolbar: MaterialToolbar, init: ActionBar.() -> Unit = {}) {
    setSupportActionBar(toolbar)
    supportActionBar?.apply {
        init()
    }
}
