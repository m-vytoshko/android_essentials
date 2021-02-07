package com.vytoshko.essentials.fragment

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import com.vytoshko.essentials.viewmodel.BaseVm

abstract class BaseFullScreenDialog<BindingType : ViewDataBinding, Vm : BaseVm> :
    BaseDialogFragment<BindingType, Vm>() {

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return super.onCreateDialog(savedInstanceState).apply {
            window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        }
    }
}