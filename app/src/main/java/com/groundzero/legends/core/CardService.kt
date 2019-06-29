package com.groundzero.legends.core

import com.groundzero.legends.data.CardApi
import com.groundzero.legends.data.Cards
import retrofit2.Call
import retrofit2.Retrofit
import javax.inject.Inject

class CardService  @Inject constructor(private val retrofit: Retrofit) {
    fun fetchAllCards(): Call<Cards> = retrofit.create(CardApi::class.java).getCards()
}