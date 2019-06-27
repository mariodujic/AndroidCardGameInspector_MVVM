package com.groundzero.legends.shared.application.di.modules

import android.app.Activity
import com.groundzero.legends.shared.utils.Logger
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module(
    includes = [FoundationModule::class]
)
class LogModule {

    @Provides
    fun provideLogger(@Named("activity") activity: Activity): Logger = Logger(activity)
}