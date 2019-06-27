package com.groundzero.legends.shared.application.di.modules

import com.groundzero.legends.shared.core.CardService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Named

@Module(
    includes = [NetworkModule::class]
)
class CardModule {

    @Provides
    @Named("cardService")
    fun provideCardService(@Named("retrofit") retrofit: Retrofit?): CardService =
        CardService(retrofit!!)
}