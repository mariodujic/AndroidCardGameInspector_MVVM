package com.groundzero.legends.data.persistence.decks

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [DeckEntity::class], version = 1)
@TypeConverters(DeckConverter::class)
abstract class DecksDatabase : RoomDatabase() {

    abstract fun decksDao(): DecksDao

    companion object {

        private var INSTANCE: DecksDatabase? = null

        fun getDecksDatabase(context: Context): DecksDatabase {
            if (INSTANCE == null) {
                synchronized(DecksDatabase::class.java) {
                    if (INSTANCE == null) {
                        // Get PhraseRoomDatabase database instance
                        INSTANCE = Room.databaseBuilder(
                            context.applicationContext,
                            DecksDatabase::class.java, "phrase_database"
                        )
                            .allowMainThreadQueries()
                            .build()
                    }
                }
            }
            return INSTANCE!!
        }
    }
}