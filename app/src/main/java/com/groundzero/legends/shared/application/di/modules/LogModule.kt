package com.groundzero.legends.shared.application.di.modules

import com.groundzero.legends.shared.utils.Logger
import dagger.Module
import dagger.Provides

@Module()
class LogModule {

    @Provides
    fun provideLogger(): Logger = Logger()
}