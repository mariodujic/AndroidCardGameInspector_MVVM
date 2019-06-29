package com.groundzero.legends.core

import com.groundzero.legends.data.CardApi
import com.groundzero.legends.data.Cards
import io.reactivex.Single
import retrofit2.Retrofit
import javax.inject.Inject

class CardService @Inject constructor(private val retrofit: Retrofit) {

    fun fetchAllCards(): Single<Cards> = retrofit.create(CardApi::class.java).getCards()
}