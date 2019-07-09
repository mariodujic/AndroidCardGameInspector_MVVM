package com.groundzero.legends.ui.cards

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.groundzero.legends.core.CardService
import com.groundzero.legends.data.shared.Card
import com.groundzero.legends.data.shared.Cards
import com.groundzero.legends.ui.shared.ViewModelBase
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CardsViewModel @Inject constructor(private val cardService: CardService) : ViewModel(), ViewModelBase {

    private lateinit var disposable: Disposable
    private val cardsLiveData: MutableLiveData<Cards> = MutableLiveData()
    private val selectedCardLiveData: MutableLiveData<Card> = MutableLiveData()

    override fun onActive() {
        cardService.fetchAllCards()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : SingleObserver<Cards> {
                override fun onSuccess(cards: Cards) {
                    cardsLiveData.value = cards
                }

                override fun onSubscribe(disposable: Disposable) {
                    this@CardsViewModel.disposable = disposable
                }

                override fun onError(e: Throwable) {
                    Log.d("bogger", e.message)
                }

            })
    }

    fun getCards() = cardsLiveData

    fun onCardSelect(card: Card) {
        selectedCardLiveData.value = card
    }

    fun getSelectedCard() = selectedCardLiveData

    override fun onClear() {
        disposable.dispose()
    }
}