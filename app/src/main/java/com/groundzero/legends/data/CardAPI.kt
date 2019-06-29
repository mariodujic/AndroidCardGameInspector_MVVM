package com.groundzero.legends.data

import retrofit2.Call
import retrofit2.http.GET

interface CardApi {

    @GET("cards")
    fun getCards(
    ): Call<Cards>
}