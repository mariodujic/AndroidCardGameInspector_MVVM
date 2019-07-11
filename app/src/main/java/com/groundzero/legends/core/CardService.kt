package com.groundzero.legends.core

import com.groundzero.legends.data.network.CardApi
import com.groundzero.legends.data.shared.Cards
import io.reactivex.Flowable
import javax.inject.Inject

class CardService @Inject constructor(private val cardApi: CardApi) {
    fun fetchAllCards(page: Int): Flowable<Cards> = cardApi.getCards(page)
}