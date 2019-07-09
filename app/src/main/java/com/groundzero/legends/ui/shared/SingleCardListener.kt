package com.groundzero.legends.ui.shared

import android.view.View
import com.groundzero.legends.data.shared.Card

interface SingleCardListener : CardToDeckListener {
    fun openSingleCardListener(card: Card): View.OnClickListener
}