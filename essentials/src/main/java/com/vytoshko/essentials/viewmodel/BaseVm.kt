package com.vytoshko.essentials.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vytoshko.essentials.livedata.SingleLiveEvent

abstract class BaseVm : ViewModel() {
    /**
     * Proper way of
     * [BaseVm] : [androidx.fragment.app.Fragment]
     * [BaseVm] : [android.app.Activity] communication
     */
    val interaction = SingleLiveEvent<Interaction?>()

    /**
     * This should be used for binding
     * visibility of [android.widget.ProgressBar]
     */
    val showLoading = MutableLiveData<Boolean?>()
}