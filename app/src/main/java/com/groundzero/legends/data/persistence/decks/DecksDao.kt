package com.groundzero.legends.data.persistence.decks

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.groundzero.legends.utils.PERSISTENCE_TABLE_DECK
import io.reactivex.Flowable

@Dao
interface DecksDao {

    @Insert
    fun insertDeck(deck: DeckEntity)

    @Query("DELETE FROM $PERSISTENCE_TABLE_DECK")
    fun deleteDecks()

    @Query("SELECT * FROM $PERSISTENCE_TABLE_DECK")
    fun getAllDecks(): Flowable<List<DeckEntity>>
}