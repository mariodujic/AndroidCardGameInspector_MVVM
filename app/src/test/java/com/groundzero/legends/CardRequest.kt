package com.groundzero.legends

import org.junit.Test

class CardRequest {

    private val networkInstance = NetworkInstance()

    @Test
    fun hasResponse_shouldReturnTrue() {
        networkInstance.getCardService().fetchAllCards()
            .test()
            .assertNoErrors()
            .assertValue { true }
            .assertOf { t -> t.hasSubscription() }
            .awaitTerminalEvent()
    }
}