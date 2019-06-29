package com.groundzero.legends.data

import io.reactivex.Single
import retrofit2.http.GET

interface CardApi {

    @GET("cards")
    fun getCards(
    ): Single<Cards>
}