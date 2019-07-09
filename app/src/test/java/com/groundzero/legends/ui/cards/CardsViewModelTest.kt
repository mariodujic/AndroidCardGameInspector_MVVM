package com.groundzero.legends.ui.cards

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.groundzero.legends.core.NetworkInstance
import com.groundzero.legends.data.shared.Card
import org.junit.Rule
import org.junit.Test

class CardsViewModelTest {

    @Rule
    @JvmField
    var instantExecutorRule = InstantTaskExecutorRule()

    private val networkInstance = NetworkInstance()
    private val cardsViewModel = CardsViewModel(networkInstance.getCardService())

    private val testObserver = networkInstance.getCardService().fetchAllCards().test()

    @Test
    fun onCardSelect_shouldReturnTrue() {
        val card = Card("", "", "", "", 0, 0, 0, 0, 0, "")
        cardsViewModel.onCardSelect(card)
        assert(cardsViewModel.getSelectedCard().value != null)
    }

    @Test
    fun cardApiHasResponse_shouldReturnTrue() {
        testObserver
            .assertNoErrors()
            .assertValue { true }
            .assertOf { result -> result.hasSubscription() }
            .awaitTerminalEvent()
    }

    @Test
    fun cardApiResponseContainCards_shouldReturnTrue() {
        testObserver
            .assertValue { result -> result.cards.isNotEmpty() }
    }

    @Test
    fun allApiCardsContainName_shouldReturnTrue() {
        testObserver
            .assertValue { result ->
                result.cards.none { card ->
                    card.name == "" && card.imageUrl == ""
                }
            }
    }
}