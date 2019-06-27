package com.groundzero.legends.shared.core

import android.view.View
import com.groundzero.legends.shared.data.Card

interface CardToDeckListener {
    fun addCardToDeckListener(card: Card): View.OnClickListener
}