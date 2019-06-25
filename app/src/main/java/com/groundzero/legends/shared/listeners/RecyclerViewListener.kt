package com.groundzero.legends.shared.listeners

import android.view.View
import com.groundzero.legends.shared.models.Card

interface RecyclerViewListener: CardToDeckListener {
    fun openSingleCardListener(card: Card): View.OnClickListener
}