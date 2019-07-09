package com.groundzero.legends.di.components

import com.groundzero.legends.di.modules.NetworkModule
import com.groundzero.legends.di.modules.PersistenceModule
import com.groundzero.legends.ui.shared.BaseFragment
import dagger.Subcomponent
import javax.inject.Singleton

@Singleton
@Subcomponent(
    modules = [
        NetworkModule::class,
        PersistenceModule::class
    ]
)
interface FoundationComponent {

    fun inject(baseFragment: BaseFragment)
}