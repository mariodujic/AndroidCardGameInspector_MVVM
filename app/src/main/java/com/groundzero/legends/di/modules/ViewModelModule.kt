package com.groundzero.legends.di.modules

import com.groundzero.legends.core.CardService
import com.groundzero.legends.ui.cards.CardsViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class ViewModelModule {

    @Singleton
    @Provides
    fun provideCardsViewModelFactory(cardService: CardService): CardsViewModelFactory =
        CardsViewModelFactory(cardService)
}