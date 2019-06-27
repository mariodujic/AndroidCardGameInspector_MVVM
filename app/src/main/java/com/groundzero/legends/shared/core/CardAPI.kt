package com.groundzero.legends.shared.core

import com.groundzero.legends.shared.data.Cards
import retrofit2.Call
import retrofit2.http.GET

interface CardApi {

    @GET("cards")
    fun getCards(
    ): Call<Cards>
}