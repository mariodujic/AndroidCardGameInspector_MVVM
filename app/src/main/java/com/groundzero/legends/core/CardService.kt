package com.groundzero.legends.core

import com.groundzero.legends.data.CardApi
import com.groundzero.legends.data.Cards
import io.reactivex.Single
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Named

class CardService @Inject constructor(private val cardApi: CardApi) {

    fun fetchAllCards(): Single<Cards> = cardApi.getCards()
}