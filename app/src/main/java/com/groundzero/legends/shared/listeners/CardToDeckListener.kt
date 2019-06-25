package com.groundzero.legends.shared.listeners

import android.view.View
import com.groundzero.legends.shared.models.Card

interface CardToDeckListener {
    fun addCardToDeckListener(card: Card): View.OnClickListener
}