package com.groundzero.legends.data.persistence.decks

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.groundzero.legends.data.shared.Card
import com.groundzero.legends.utils.PERSISTENCE_TABLE_DECK

@Entity(tableName = PERSISTENCE_TABLE_DECK)
class DeckEntity(
    var name: String,
    @TypeConverters(DeckConverter::class)
    var cards: List<Card>
) {
    @PrimaryKey(autoGenerate = true)
    var id = 0
}