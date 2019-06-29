package com.groundzero.legends.di.modules

import com.groundzero.legends.core.CardService
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