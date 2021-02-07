package com.vytoshko.essentials.widget.adapter

interface IAdapter<ItemType> {
    fun setData(data: List<ItemType>)
}