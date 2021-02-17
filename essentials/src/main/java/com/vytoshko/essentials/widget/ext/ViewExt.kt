package com.vytoshko.essentials.widget.ext

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import androidx.annotation.LayoutRes

@Suppress("UNCHECKED_CAST")
fun <ViewType : View> Context.inflateTypedView(@LayoutRes layoutRes: Int): ViewType {
    return LayoutInflater.from(this).inflate(layoutRes, null) as ViewType
}

fun View.debounce(actionToPerform: () -> Unit, delayMillis: Long) {
    handler.run {
        removeCallbacksAndMessages(null)
        postDelayed({ actionToPerform() }, delayMillis)
    }
}