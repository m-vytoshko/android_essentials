package com.vytoshko.essentials.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.vytoshko.essentials.BR
import com.vytoshko.essentials.viewmodel.BaseVm
import com.vytoshko.essentials.viewmodel.Interaction

abstract class BaseFragment<BindingType : ViewDataBinding, Vm : BaseVm> : Fragment(), IFragment {
    protected abstract val vm: Vm
    protected lateinit var binding: BindingType

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, getLayoutRes(), container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.setVariable(BR.viewModel, vm)
        vm.interaction.observe(viewLifecycleOwner, interactionHandler)
        return binding.root
    }

    protected open fun handleInteraction(interaction: Interaction?) {}

    private val interactionHandler = Observer<Interaction?> {
        handleInteraction(it)
    }
}