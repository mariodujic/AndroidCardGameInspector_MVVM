package com.groundzero.legends.ui.cards

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.groundzero.legends.core.CardService
import com.groundzero.legends.data.shared.Card
import com.groundzero.legends.ui.shared.ViewModelBase
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CardsViewModel @Inject constructor(private val cardService: CardService) : ViewModel(), ViewModelBase {

    private lateinit var disposable: Disposable
    private val cardsList = mutableListOf<Card>()
    private val cardsLiveData: MutableLiveData<List<Card>> = MutableLiveData()
    private val errorCardsLiveData: MutableLiveData<Boolean> = MutableLiveData()
    private val selectedCardLiveData: MutableLiveData<Card> = MutableLiveData()

    override fun onActive() {
        disposable = Flowable.range(0, 3)
            .doOnSubscribe { cardsList.clear() }
            .concatMap { iterationNumber ->
                cardService.fetchAllCards(iterationNumber)
                    .flatMapIterable { response -> response.cards }
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnNext { card -> cardsList.add(card) }
            .subscribe(
                { cardsLiveData.value = cardsList },
                { errorCardsLiveData.value = true }
            )
    }

    fun getCards(): LiveData<List<Card>> = cardsLiveData

    fun getCardsError(): LiveData<Boolean> = errorCardsLiveData

    fun onCardSelect(card: Card) {
        selectedCardLiveData.value = card
    }

    fun getSelectedCard(): LiveData<Card> = selectedCardLiveData

    override fun onClear() {
        disposable.dispose()
    }
}