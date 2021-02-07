package com.vytoshko.sample.fragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.vytoshko.essentials.viewmodel.BaseVm
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit

class HomeVm : BaseVm() {
    val data = MutableLiveData<List<String>?>()

    init {
        refreshData()
    }

    fun refreshData() {
        showLoading.value = true

        viewModelScope.launch {
            delay(TimeUnit.SECONDS.toMillis(2))
            data.postValue(
                listOf(
                    "item1",
                    "item2",
                    "item3",
                    "item4",
                    "item5"
                )
            )
            showLoading.postValue(false)
        }
    }
}