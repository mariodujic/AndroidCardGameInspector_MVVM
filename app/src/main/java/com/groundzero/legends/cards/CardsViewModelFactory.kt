package com.groundzero.legends.cards

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.groundzero.legends.shared.core.CardService
import javax.inject.Inject

class CardsViewModelFactory @Inject constructor(private val cardService: CardService): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(CardsViewModel::class.java)) {
            CardsViewModel(this.cardService) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }

}