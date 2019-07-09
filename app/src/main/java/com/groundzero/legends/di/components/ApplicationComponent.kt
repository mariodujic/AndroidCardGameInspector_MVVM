package com.groundzero.legends.di.components

import android.app.Application
import com.groundzero.legends.di.modules.*
import dagger.Component

@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun inject(application: Application)

    fun foundationComponent(
        persistenceModule: PersistenceModule,
        networkModule: NetworkModule
    ): FoundationComponent
}