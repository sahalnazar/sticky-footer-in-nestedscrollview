package io.github.sahalnazar.stickyfooter.utils

import android.graphics.Rect
import android.view.View
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.NestedScrollView
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

object ExtensionFunctions {

    fun <T : ViewDataBinding?> AppCompatActivity.getViewBinding(@LayoutRes resId: Int): T {
        return DataBindingUtil.setContentView<T>(this, resId)
    }

    fun NestedScrollView.isViewVisible(view: View): Boolean {
        val scrollBounds = Rect()
        this.getDrawingRect(scrollBounds)
        val top = view.y
        val bottom = view.height + top
        return scrollBounds.bottom > bottom
    }
}