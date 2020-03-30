package de.hkokocin.android

import android.content.Intent
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import de.hkokocin.redukt.BaseView

abstract class BaseActivity(private val optionsMenu: Int = 0) : AppCompatActivity() {

    private val optionItemListeners = mutableMapOf<Int, () -> Boolean>()
    private var externalOnBackPressed: () -> Boolean = { false }
    private var onActivityResult: (requestCode: Int, resultCode: Int, data: Intent?) -> Boolean = { _, _, _ -> false }

    fun setContentView(view: BaseView, @LayoutRes layout: Int) {
        val contentView = LayoutInflater.from(this).inflate(layout, null)
        setContentView(contentView)
        view.setRootView(contentView)
        view.bindToLifecycle(lifecycle)
    }

    fun setOnBackPressedListener(listener: () -> Boolean) {
        externalOnBackPressed = listener
    }

    fun setOnOptionsItemSelectedListener(action: Int, listener: () -> Boolean) {
        optionItemListeners[action] = listener
    }

    fun setOnActivityResultListener(listener: (requestCode: Int, resultCode: Int, data: Intent?) -> Boolean) {
        onActivityResult = listener
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (!onActivityResult.invoke(requestCode, resultCode, data))
            super.onActivityResult(requestCode, resultCode, data)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        optionItemListeners[item.itemId]?.apply { return invoke() }

        if (item.itemId == android.R.id.home) {
            onBackPressed()
            return true
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        if (externalOnBackPressed()) return
        super.onBackPressed()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        if (optionsMenu != 0)
            menuInflater.inflate(optionsMenu, menu)

        return super.onCreateOptionsMenu(menu)
    }
}
