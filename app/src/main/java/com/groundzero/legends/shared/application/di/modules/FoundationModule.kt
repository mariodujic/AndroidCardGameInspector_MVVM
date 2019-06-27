package com.groundzero.legends.shared.application.di.modules

import android.app.Activity
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class FoundationModule(private val activity: Activity) {

    @Singleton
    @Provides
    fun provideContext(): Context = activity

    @Singleton
    @Provides
    @Named("activity")
    fun provideActivity(): Activity = activity
}