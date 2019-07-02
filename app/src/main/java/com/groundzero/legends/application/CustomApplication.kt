package com.groundzero.legends.application

import android.app.Application
import com.groundzero.legends.di.components.ApplicationComponent
import com.groundzero.legends.di.components.DaggerApplicationComponent
import com.groundzero.legends.di.components.FoundationComponent
import com.groundzero.legends.di.modules.NetworkModule
import com.groundzero.legends.di.modules.ViewModelModule
import uk.co.chrisjenx.calligraphy.CalligraphyConfig

class CustomApplication : Application() {

    private val applicationComponent: ApplicationComponent = DaggerApplicationComponent.builder().build()
    private val foundationComponent: FoundationComponent

    init {
        applicationComponent.inject(this)
        foundationComponent = applicationComponent
            .foundationComponent(
                NetworkModule(),
                ViewModelModule()
            )
    }

    fun getFoundationComponent(): FoundationComponent = foundationComponent

    override fun onCreate() {
        super.onCreate()
        CalligraphyConfig.initDefault(
            CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/Belwe-Medium.otf")
                .setFontAttrId(android.R.attr.font)
                .build()
        )
    }
}