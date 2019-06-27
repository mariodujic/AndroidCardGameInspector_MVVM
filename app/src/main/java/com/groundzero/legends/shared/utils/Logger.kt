package com.groundzero.legends.shared.utils

import android.app.Activity
import android.util.Log
import javax.inject.Inject

class Logger @Inject constructor(private val activity: Activity) {

    fun doLog(message: String){
        Log.d(activity.localClassName, message)
    }
}