package com.groundzero.legends.shared.di.components

import com.groundzero.legends.cards.viewmodel.CardsViewModel
import com.groundzero.legends.shared.di.modules.FoundationModule
import com.groundzero.legends.shared.di.modules.NetworkModule
import dagger.Subcomponent
import javax.inject.Singleton

@Singleton
@Subcomponent(modules = [FoundationModule::class, NetworkModule::class])
interface FoundationComponent {

    fun inject(viewModel: CardsViewModel)
}