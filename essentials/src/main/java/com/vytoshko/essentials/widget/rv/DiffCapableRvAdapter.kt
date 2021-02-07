package com.vytoshko.essentials.widget.rv

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil

abstract class DiffCapableRvAdapter<ItemType, BindingType : ViewDataBinding> :
    BaseRvAdapter<ItemType, BindingType>() {

    override fun setData(data: List<ItemType>) {
        val diffResult = DiffUtil.calculateDiff(getDiffCallback(dataSet, data))
        dataSet.clear()
        dataSet.addAll(data)
        diffResult.dispatchUpdatesTo(this)
    }

    protected abstract fun areItemsTheSame(oldItem: ItemType, newItem: ItemType): Boolean
    protected abstract fun areContentsTheSame(oldItem: ItemType, newItem: ItemType): Boolean

    private fun getDiffCallback(
        oldData: List<ItemType>,
        newData: List<ItemType>
    ): DiffUtil.Callback {
        return object : DiffUtil.Callback() {

            override fun getOldListSize() = oldData.size

            override fun getNewListSize() = newData.size

            override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
                areItemsTheSame(oldData[oldItemPosition], newData[newItemPosition])

            override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) =
                areContentsTheSame(oldData[oldItemPosition], newData[newItemPosition])
        }
    }
}