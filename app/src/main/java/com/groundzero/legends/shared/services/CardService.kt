package com.groundzero.legends.shared.services

import com.groundzero.legends.cards.network.CardApi
import com.groundzero.legends.shared.models.Cards
import retrofit2.Call
import retrofit2.Retrofit
import javax.inject.Inject

class CardService  @Inject constructor(private val retrofit: Retrofit) {

    fun fetchAllCards(): Call<Cards> = retrofit.create(CardApi::class.java).getCards()
}