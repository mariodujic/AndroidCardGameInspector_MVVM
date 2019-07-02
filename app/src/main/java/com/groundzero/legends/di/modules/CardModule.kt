package com.groundzero.legends.di.modules

import com.groundzero.legends.core.CardService
import com.groundzero.legends.data.CardApi
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module(
    includes = [NetworkModule::class]
)
class CardModule {

    @Provides
    @Named("cardService")
    fun provideCardService(@Named("cardApi") cardApi: CardApi): CardService =
        CardService(cardApi)
}