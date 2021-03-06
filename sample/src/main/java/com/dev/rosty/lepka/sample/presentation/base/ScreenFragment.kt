package com.dev.rosty.lepka.sample.presentation.base

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dev.rosty.lepka.sample.injection.VmFactory


abstract class ScreenFragment<VM : ViewModel,  B : ViewDataBinding> : Fragment() {

    protected lateinit var viewModel: VM
    protected lateinit var binding:   B

    private var isFirstCreate: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProviders
                .of(this, VmFactory(this))
                .get(getViewModelClass())
    }

    override fun onCreateView(inflater:  LayoutInflater?,
                              container: ViewGroup?,
                              state:     Bundle?): View? {

        if (isFirstCreate) inflateBinding(inflater, container, state)

        return binding.root
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        isFirstCreate = false
    }

    protected abstract fun getViewModelClass(): Class<VM>
    protected abstract fun inflateBinding(inflater: LayoutInflater?, container: ViewGroup?, state: Bundle?)
}
