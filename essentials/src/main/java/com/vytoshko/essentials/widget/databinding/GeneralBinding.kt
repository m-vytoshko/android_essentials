package com.vytoshko.essentials.widget.databinding

import android.view.View
import androidx.databinding.BindingAdapter

object GeneralBinding {
    @JvmStatic
    @BindingAdapter("bindVisibleGone")
    fun bindVisibleGone(view: View, isVisible: Boolean?) {
        view.visibility = if (isVisible == true) View.VISIBLE else View.GONE
    }
}