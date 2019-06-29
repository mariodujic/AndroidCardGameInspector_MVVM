package com.groundzero.legends.di.modules

import com.groundzero.legends.utils.Logger
import dagger.Module
import dagger.Provides

@Module()
class LogModule {

    @Provides
    fun provideLogger(): Logger = Logger()
}