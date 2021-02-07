package com.vytoshko.essentials.widget.rv

import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import com.vytoshko.essentials.RequiresLayoutResId
import com.vytoshko.essentials.widget.adapter.IAdapter

abstract class PagedRvAdapter<ItemType : Any, BindingType : ViewDataBinding>(diffCallback: DiffUtil.ItemCallback<ItemType>) :
    PagedListAdapter<ItemType, BaseVh<BindingType>>(diffCallback),
    RequiresLayoutResId, IAdapter<ItemType> {

    final override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        BaseVh.inflate<BindingType>(parent, getLayoutRes())
}