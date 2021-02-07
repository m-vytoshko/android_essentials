package com.vytoshko.essentials.widget.databinding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.vytoshko.essentials.widget.adapter.IAdapter

object RvDataBinding {
    @Suppress("UNCHECKED_CAST")
    @JvmStatic
    @BindingAdapter("bindRvData")
    fun bindRvData(rv: RecyclerView, data: List<*>?) {
        (rv.adapter as IAdapter<Any>?)?.setData(
            data as List<Any>? ?: listOf()
        )
    }
}