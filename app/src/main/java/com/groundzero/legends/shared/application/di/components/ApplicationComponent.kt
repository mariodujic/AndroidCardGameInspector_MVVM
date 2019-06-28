package com.groundzero.legends.shared.application.di.components

import android.app.Application
import com.groundzero.legends.shared.application.di.modules.*
import dagger.Component

@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun inject(application: Application)
    fun foundationComponent(
        networkModule: NetworkModule,
        logModule: LogModule,
        cardModule: CardModule,
        viewModelModule: ViewModelModule
    ): FoundationComponent
}