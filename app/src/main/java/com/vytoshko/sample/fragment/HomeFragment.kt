package com.vytoshko.sample.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.vytoshko.essentials.fragment.BaseFragment
import com.vytoshko.sample.R
import com.vytoshko.sample.databinding.FragmentHomeBinding

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeVm>() {
    override val vm: HomeVm by viewModels()
    override fun getLayoutRes() = R.layout.fragment_home

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState).apply {
            binding.homeRv.adapter = HomeAdapter()
        }
    }
}