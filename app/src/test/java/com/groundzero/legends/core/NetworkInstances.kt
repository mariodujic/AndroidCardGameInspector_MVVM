package com.groundzero.legends.core

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.groundzero.legends.core.CardService
import com.groundzero.legends.utils.BASE_URL
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class NetworkInstance {

    private fun getGson(): Gson =
        GsonBuilder()
            .setLenient()
            .create()

    private fun getRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(getGson()))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

    fun getCardService(): CardService = CardService(getRetrofit())
}