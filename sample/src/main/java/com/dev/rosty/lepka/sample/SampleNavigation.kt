package com.dev.rosty.lepka.sample

import com.dev.rosty.lepka.lib.Screen
import com.dev.rosty.lepka.lib.module.LepkaModule
import com.dev.rosty.lepka.lib.module.Priority
import com.dev.rosty.lepka.lib.screen.LepkaScreen
import com.dev.rosty.lepka.sample.presentation.modules.BotBarActivity
import com.dev.rosty.lepka.sample.presentation.modules.ListActivity
import com.dev.rosty.lepka.sample.presentation.modules.SplashActivity
import com.dev.rosty.lepka.sample.presentation.screens.empty.EmptyFragment
import com.dev.rosty.lepka.sample.presentation.screens.add.AddFragment
import com.dev.rosty.navi.presentation.screens.purple.ListFragment
import com.dev.rosty.lepka.sample.presentation.screens.picker.PickerFragment


class SplashModule : LepkaModule() {

    override fun provideContainer() = R.id.container

    override fun getActivityClass() = SplashActivity::class.java

    override fun canOpen(screen: Screen) = screen is PickerScreen
}

class BotBarModule : LepkaModule() {

    override fun provideContainer() = R.id.container

    override fun getActivityClass() = BotBarActivity::class.java

    override fun canOpen(screen: Screen) = screen is AddScreen

    override fun getPriority(screen: Screen)
            = if (screen is AddScreen) Priority.MEDIUM else Priority.HIGH
}

class ListModule : LepkaModule() {

    override fun provideContainer()= R.id.container

    override fun getActivityClass() = ListActivity::class.java

    override fun canOpen(screen: Screen)
            = screen is ListScreen || screen is EmptyScreen
}

object ListScreen : LepkaScreen(ListFragment::class.java)

object PickerScreen : LepkaScreen(PickerFragment::class.java)

class AddScreen(count: Int) : LepkaScreen(AddFragment::class.java) {

    init { data.putInt(EXTRA_COUNT, count) }
}

class EmptyScreen(title: String) : LepkaScreen(EmptyFragment::class.java) {

    init { data.putString(EXTRA_TITLE, title) }
}

const val EXTRA_COUNT = "extra_count"
const val EXTRA_TITLE = "extra_title"
