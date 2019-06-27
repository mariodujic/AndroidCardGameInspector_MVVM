package com.groundzero.legends.shared.application

import android.app.Application
import com.groundzero.legends.shared.application.di.components.ApplicationComponent
import com.groundzero.legends.shared.application.di.components.DaggerApplicationComponent
import uk.co.chrisjenx.calligraphy.CalligraphyConfig

class CustomApplication : Application() {

    private val applicationComponent: ApplicationComponent = DaggerApplicationComponent.builder().build()
    init { applicationComponent.inject(this) }
    fun getApplicationComponent(): ApplicationComponent = applicationComponent

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