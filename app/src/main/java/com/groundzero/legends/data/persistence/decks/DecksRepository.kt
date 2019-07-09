package com.groundzero.legends.data.persistence.decks

import io.reactivex.Flowable
import javax.inject.Inject

class DecksRepository @Inject constructor(private val decksDao: DecksDao) {

    fun getDecks(): Flowable<List<DeckEntity>> = decksDao.getAllDecks()

    fun insertDeck(deck: DeckEntity) = decksDao.insertDeck(deck)

    fun deleteDecks() = decksDao.deleteDecks()
}