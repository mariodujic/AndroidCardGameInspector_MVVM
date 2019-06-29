package com.groundzero.legends.di.modules

import com.groundzero.legends.core.CardService
import com.groundzero.legends.ui.cards.CardsViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module(
    includes = [CardModule::class]
)
class ViewModelModule {

    @Singleton
    @Provides
    fun provideCardsViewModelFactory(@Named("cardService") cardService: CardService): CardsViewModelFactory =
        CardsViewModelFactory(cardService)
}