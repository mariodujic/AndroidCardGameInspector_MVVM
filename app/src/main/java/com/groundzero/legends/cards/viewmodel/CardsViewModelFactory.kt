package com.groundzero.legends.cards.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.groundzero.legends.shared.di.components.FoundationComponent

class CardsViewModelFactory(private val foundationComponent: FoundationComponent) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CardsViewModel(foundationComponent) as T
    }
}