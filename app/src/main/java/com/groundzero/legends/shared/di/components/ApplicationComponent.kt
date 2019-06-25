package com.groundzero.legends.shared.di.components

import android.app.Application
import com.groundzero.legends.shared.di.modules.ApplicationModule
import com.groundzero.legends.shared.di.modules.FoundationModule
import com.groundzero.legends.shared.di.modules.NetworkModule
import dagger.Component

@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun inject(application: Application)
    fun foundationComponent(
        foundationModule: FoundationModule,
        networkModule: NetworkModule
    ): FoundationComponent
}