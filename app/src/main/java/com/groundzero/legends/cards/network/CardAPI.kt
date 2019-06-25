package com.groundzero.legends.cards.network

import com.groundzero.legends.shared.models.Cards
import retrofit2.Call
import retrofit2.http.GET

interface CardApi {

    @GET("cards")
    fun getCards(
    ): Call<Cards>
}