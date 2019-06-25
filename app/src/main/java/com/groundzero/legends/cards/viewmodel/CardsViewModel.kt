package com.groundzero.legends.cards.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.groundzero.legends.shared.models.Card
import com.groundzero.legends.shared.models.Cards
import com.groundzero.legends.shared.di.components.FoundationComponent
import com.groundzero.legends.shared.services.CardService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class CardsViewModel(foundationComponent: FoundationComponent) : ViewModel() {

    @Inject
    lateinit var cardService: CardService

    private val cards: MutableLiveData<Cards> = MutableLiveData()
    private val selectedCard: MutableLiveData<Card> = MutableLiveData()

    init {
        foundationComponent.inject(this)
    }

    fun setCards() {
        cardService.fetchAllCards().enqueue(object: Callback<Cards> {
            override fun onFailure(call: Call<Cards>, t: Throwable) {
                cards.value = null
            }

            override fun onResponse(call: Call<Cards>, response: Response<Cards>) {
                cards.value = response.body()
            }

        })
    }

    fun getCards() = cards

    fun setSelectedCard(card: Card) {
        selectedCard.value = card
    }

    fun getSelectedCard() = selectedCard
}