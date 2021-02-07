package com.vytoshko.essentials.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import com.vytoshko.essentials.BR
import com.vytoshko.essentials.viewmodel.BaseVm
import com.vytoshko.essentials.viewmodel.Interaction

abstract class BaseActivity<BindingType : ViewDataBinding, Vm : BaseVm> : AppCompatActivity(),
    IActivity {

    protected abstract val vm: Vm
    protected lateinit var binding: BindingType

    protected open fun handleInteraction(interaction: Interaction?) {}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, getLayoutRes())
        binding.lifecycleOwner = this
        binding.setVariable(BR.viewModel, vm)
        vm.interaction.observe(this, interactionHandler)
    }

    private val interactionHandler = Observer<Interaction?> {
        handleInteraction(it)
    }
}