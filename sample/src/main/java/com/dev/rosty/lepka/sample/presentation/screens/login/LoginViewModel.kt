package com.dev.rosty.lepka.sample.presentation.screens.login

import android.arch.lifecycle.ViewModel
import com.dev.rosty.lepka.lib.Lepka
import com.dev.rosty.lepka.lib.command.ForwardClear
import com.dev.rosty.lepka.sample.AccountScreen
import com.dev.rosty.lepka.sample.NewsScreen
import com.dev.rosty.lepka.sample.injection.screen.ScreenComponent
import javax.inject.Inject


class LoginViewModel : ViewModel(), ScreenComponent.Injectable {

    @Inject lateinit var lepka: Lepka


    override fun inject(screenComponent: ScreenComponent)
            = screenComponent.inject(this)


    fun onLoginClick() = lepka.execute(ForwardClear(NewsScreen))
}