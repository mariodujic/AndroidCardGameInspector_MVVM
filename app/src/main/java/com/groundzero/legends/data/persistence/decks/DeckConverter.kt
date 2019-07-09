package com.groundzero.legends.data.persistence.decks

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.groundzero.legends.data.shared.Card
import java.io.Serializable


class DeckConverter : Serializable {

    @TypeConverter
    fun fromOptionValuesList(optionValues: List<Card>?): String? {
        if (optionValues == null) {
            return null
        }
        val gson = Gson()
        val type = object : TypeToken<List<Card>>() {}.type
        return gson.toJson(optionValues, type)
    }

    @TypeConverter
    fun toOptionValuesList(cardsString: String?): List<Card>? {
        if (cardsString == null) {
            return null
        }
        val gson = Gson()
        val type = object : TypeToken<List<Card>>() {}.type
        return gson.fromJson<List<Card>>(cardsString, type)
    }

}