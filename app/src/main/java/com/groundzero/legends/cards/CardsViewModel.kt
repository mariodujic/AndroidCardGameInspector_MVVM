package com.groundzero.legends.cards

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.groundzero.legends.shared.data.Card
import com.groundzero.legends.shared.data.Cards
import com.groundzero.legends.shared.core.CardService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class CardsViewModel constructor(cardService: CardService) : ViewModel() {

    private val cards: MutableLiveData<Cards> = MutableLiveData()
    private val selectedCard: MutableLiveData<Card> = MutableLiveData()

    init {
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