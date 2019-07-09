package com.groundzero.legends.core

import com.groundzero.legends.data.network.CardApi
import com.groundzero.legends.data.shared.Cards
import io.reactivex.Single
import javax.inject.Inject

class CardService @Inject constructor(private val cardApi: CardApi) {

    fun fetchAllCards(): Single<Cards> = cardApi.getCards()
}