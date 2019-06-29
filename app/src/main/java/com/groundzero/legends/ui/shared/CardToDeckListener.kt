package com.groundzero.legends.ui.shared

import android.view.View
import com.groundzero.legends.data.Card

interface CardToDeckListener {
    fun addCardToDeckListener(card: Card): View.OnClickListener
}