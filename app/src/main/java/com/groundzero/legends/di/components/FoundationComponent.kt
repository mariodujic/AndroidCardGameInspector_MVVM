package com.groundzero.legends.di.components

import com.groundzero.legends.di.modules.CardModule
import com.groundzero.legends.di.modules.LogModule
import com.groundzero.legends.di.modules.NetworkModule
import com.groundzero.legends.di.modules.ViewModelModule
import com.groundzero.legends.ui.shared.BaseFragment
import dagger.Subcomponent
import javax.inject.Singleton

@Singleton
@Subcomponent(
    modules = [
        NetworkModule::class,
        LogModule::class,
        CardModule::class,
        ViewModelModule::class
    ]
)
interface FoundationComponent {

    fun inject(baseFragment: BaseFragment)
}