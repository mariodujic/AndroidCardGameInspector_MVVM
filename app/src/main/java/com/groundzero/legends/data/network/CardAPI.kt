package com.groundzero.legends.data.network

import com.groundzero.legends.data.shared.Cards
import io.reactivex.Single
import retrofit2.http.GET

interface CardApi {

    @GET("cards")
    fun getCards(
    ): Single<Cards>
}