package com.vytoshko.sample.activity

import androidx.activity.viewModels
import com.vytoshko.essentials.activity.BaseActivity
import com.vytoshko.sample.R
import com.vytoshko.sample.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding, MainVm>() {
    override val vm: MainVm by viewModels()
    override fun getLayoutRes() = R.layout.activity_main
}