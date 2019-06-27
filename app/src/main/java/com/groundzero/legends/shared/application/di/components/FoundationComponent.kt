package com.groundzero.legends.shared.application.di.components

import com.groundzero.legends.shared.application.di.modules.*
import com.groundzero.legends.shared.core.BaseFragment
import dagger.Subcomponent
import javax.inject.Singleton

@Singleton
@Subcomponent(
    modules = [
        FoundationModule::class,
        NetworkModule::class,
        LogModule::class,
        CardModule::class,
        ViewModelModule::class
    ]
)
interface FoundationComponent {

    fun inject(baseFragment: BaseFragment)
}