package com.groundzero.legends.ui.cards

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.groundzero.legends.core.CardService
import com.groundzero.legends.data.Card
import com.groundzero.legends.data.Cards
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class CardsViewModel constructor(private val cardService: CardService) : ViewModel() {

    private lateinit var mDisposable: Disposable
    private val cardsLiveData: MutableLiveData<Cards> = MutableLiveData()
    private val selectedCardLiveData: MutableLiveData<Card> = MutableLiveData()

    fun fetchCards() {
        cardService.fetchAllCards()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : SingleObserver<Cards> {
                override fun onSuccess(cards: Cards) {
                    cardsLiveData.value = cards
                }

                override fun onSubscribe(disposable: Disposable) {
                    mDisposable = disposable
                }

                override fun onError(e: Throwable) {
                    cardsLiveData.value = null
                }

            })
    }

    fun getCards() = cardsLiveData

    fun onCardSelect(card: Card) {
        selectedCardLiveData.value = card
    }

    fun getSelectedCard() = selectedCardLiveData

    fun onClear() {
        mDisposable.dispose()
    }
}