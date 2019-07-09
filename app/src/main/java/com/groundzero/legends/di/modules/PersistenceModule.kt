package com.groundzero.legends.di.modules

import android.app.Application
import androidx.room.Room
import com.groundzero.legends.data.persistence.decks.DecksDao
import com.groundzero.legends.data.persistence.decks.DecksDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class PersistenceModule(private val application: Application) {

    @Singleton
    @Provides
    fun provideDecksDatabase(): DecksDatabase =
        Room.databaseBuilder(application, DecksDatabase::class.java, "something")
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()

    @Singleton
    @Provides
    fun provideDecksDao(): DecksDao = provideDecksDatabase().decksDao()
}