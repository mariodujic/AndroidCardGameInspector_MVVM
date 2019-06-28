package com.groundzero.legends.shared.utils

import android.util.Log
import javax.inject.Inject

class Logger @Inject constructor() {

    fun doLog(message: String) {
        Log.d(LOGGER, message)
    }
}