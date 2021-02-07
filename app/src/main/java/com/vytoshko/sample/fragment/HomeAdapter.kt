package com.vytoshko.sample.fragment

import com.vytoshko.essentials.widget.rv.BaseRvAdapter
import com.vytoshko.essentials.widget.rv.BaseVh
import com.vytoshko.sample.R
import com.vytoshko.sample.databinding.ItemHomeBinding

class HomeAdapter : BaseRvAdapter<String, ItemHomeBinding>() {
    override fun getLayoutRes(viewType: Int) = R.layout.item_home

    override fun onBindViewHolder(holder: BaseVh<ItemHomeBinding>, position: Int) {
        holder.binding.title = getItem(position)
    }
}