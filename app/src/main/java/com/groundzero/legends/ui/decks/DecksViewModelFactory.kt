package com.groundzero.legends.ui.decks

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.groundzero.legends.data.persistence.decks.DecksRepository
import javax.inject.Inject

class DecksViewModelFactory @Inject constructor(private val decksRepository: DecksRepository) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(DecksViewModel::class.java)) {
            DecksViewModel(this.decksRepository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }

}