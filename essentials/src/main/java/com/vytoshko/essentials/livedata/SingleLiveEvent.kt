package com.vytoshko.essentials.livedata

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import java.util.concurrent.atomic.AtomicBoolean

/**
 * [SingleLiveEvent] notifies only ones
 */
class SingleLiveEvent<T> : MutableLiveData<T>() {
    private val isPending = AtomicBoolean(false)

    override fun observe(owner: LifecycleOwner, observer: Observer<in T>) {
        // Observe the internal MutableLiveData
        super.observe(owner, { data ->
            if (isPending.compareAndSet(true, false)) {
                observer.onChanged(data)
            }
        })
    }

    override fun setValue(t: T?) {
        isPending.set(true)
        super.setValue(t)
    }

    fun flush() {
        value = null
    }
}