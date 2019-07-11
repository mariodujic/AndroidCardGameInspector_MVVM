package com.groundzero.legends.data.network

import com.groundzero.legends.data.shared.Cards
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

interface CardApi {

    @GET("cards")
    fun getCards(
        @Query("page") page: Int
    ): Flowable<Cards>
}