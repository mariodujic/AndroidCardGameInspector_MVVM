package com.groundzero.legends.ui.decks

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.groundzero.legends.data.persistence.decks.DeckEntity
import com.groundzero.legends.data.persistence.decks.DecksRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class DecksViewModel @Inject constructor(private val decksRepository: DecksRepository) {

    private lateinit var disposable: Disposable
    private val decksLiveData: MutableLiveData<List<DeckEntity>> = MutableLiveData()
    private val selectedDeckLiveData: LiveData<DeckEntity> = MutableLiveData()

    fun onActive() {
        disposable = decksRepository.run {
            getDecks()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { t -> decksLiveData.value = t }
        }
    }

    fun onInsert() {
        decksRepository.insertDeck(DeckEntity("Deck One", listOf()))
    }

    fun onClear() {
        disposable.dispose()
    }

    fun getDecksLiveData(): LiveData<List<DeckEntity>> = decksLiveData
}