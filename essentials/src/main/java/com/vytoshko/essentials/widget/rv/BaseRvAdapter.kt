package com.vytoshko.essentials.widget.rv

import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.vytoshko.essentials.RequiresVhLayoutResId
import com.vytoshko.essentials.widget.adapter.IAdapter

abstract class BaseRvAdapter<ItemType, BindingType : ViewDataBinding> :
    RecyclerView.Adapter<BaseVh<BindingType>>(), IAdapter<ItemType>, RequiresVhLayoutResId {

    protected val dataSet = ArrayList<ItemType>()

    override fun getItemCount() = dataSet.size

    open fun getItem(position: Int) = dataSet[position]

    override fun setData(data: List<ItemType>) {
        dataSet.clear()
        dataSet.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        BaseVh.inflate<BindingType>(parent, getLayoutRes(viewType))
}