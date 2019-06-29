package com.groundzero.legends.ui.cards

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.groundzero.legends.data.Card
import com.groundzero.legends.data.Cards
import com.groundzero.legends.core.CardService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CardsViewModel constructor(private val cardService: CardService) : ViewModel() {

    private val cards: MutableLiveData<Cards> = MutableLiveData()
    private val selectedCard: MutableLiveData<Card> = MutableLiveData()

    init {
       fetchCards()
    }

    fun fetchCards() {
        cardService.fetchAllCards().enqueue(object: Callback<Cards> {

            override fun onResponse(call: Call<Cards>, response: Response<Cards>) {
                cards.value = response.body()
            }

            override fun onFailure(call: Call<Cards>, t: Throwable) {
                cards.value = null
            }
        })
    }

    fun getCards() = cards

    fun onCardSelect(card: Card) {
        selectedCard.value = card
    }

    fun getSelectedCard() = selectedCard
}