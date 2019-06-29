package com.groundzero.legends.di.components

import android.app.Application
import com.groundzero.legends.di.modules.*
import dagger.Component

@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun inject(application: Application)
    fun inject(test: Any)

    fun foundationComponent(
        networkModule: NetworkModule,
        logModule: LogModule,
        cardModule: CardModule,
        viewModelModule: ViewModelModule
    ): FoundationComponent
}