package com.groundzero.legends.shared.application.di.modules

import com.groundzero.legends.cards.CardsViewModelFactory
import com.groundzero.legends.shared.core.CardService
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