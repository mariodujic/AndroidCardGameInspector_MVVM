package com.groundzero.legends.shared.core

import android.view.View
import com.groundzero.legends.shared.data.Card

interface RecyclerViewListener: CardToDeckListener {
    fun openSingleCardListener(card: Card): View.OnClickListener
}